package com.example.dwp.services;

import com.example.dwp.entities.User;
import com.example.dwp.utils.DistanceCalculator;
import com.example.dwp.utils.CityGeoPoint;
import com.example.dwp.utils.GeoPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Value("${base.url}")
    private String baseUrl;

    @Autowired
    private RestTemplate restTemplate;

    private List<User> getAllUsers() {
        ResponseEntity<User[]> responseEntity =
                restTemplate.getForEntity(
                        baseUrl + "/users",
                        User[].class
                );

        return getUserList(responseEntity);
    }

    private List<User> getAllUsersNearTo(double latitude, double longitude) {
        List<User> list = getAllUsers()
                .stream()
                .filter(user -> DistanceCalculator.getDistanceInMiles(
                        user.getLatitude(),
                        user.getLongitude(),
                        latitude,
                        longitude
                ) < 50).collect(Collectors.toList());
        return list;
    }

    private List<User> getAllUsersOfCity(String city) {
        ResponseEntity<User[]> responseEntity =
                restTemplate.getForEntity(
                        baseUrl + "/city/" + city + "/users",
                        User[].class
                );

        return getUserList(responseEntity);
    }

    public List<User> getUsersInOrNear(String city) {
        GeoPoint geoPoint = CityGeoPoint.getFor(city);
        List<User> userList = this.getAllUsersOfCity(city);
        userList.addAll(this.getAllUsersNearTo(geoPoint.getLatitude(), geoPoint.getLongitude()));
        return userList;
    }

    private List<User> getUserList(ResponseEntity<User[]> responseEntity) {
        User[] usersArray = responseEntity.getBody();

        if (usersArray != null) {
            return Arrays.stream(usersArray).collect(Collectors.toList());
        } else {
            return List.of();
        }
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
