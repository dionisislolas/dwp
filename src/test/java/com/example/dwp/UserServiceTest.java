package com.example.dwp;

import com.example.dwp.entities.User;
import com.example.dwp.services.UserService;
import com.example.dwp.utils.CityGeoPoint;
import com.example.dwp.utils.GeoPoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Value("${base.url}")
    private String baseUrl;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserService service = new UserService();

    @BeforeEach
    void setUp() {
        service.setBaseUrl(baseUrl);
    }

    @Test
    public void test() {

        GeoPoint londonGeo = CityGeoPoint.getFor("London");
        GeoPoint athensGeo = CityGeoPoint.getFor("Athens");
        GeoPoint munichGeo = CityGeoPoint.getFor("Munich");

        User user1 = new User(
                "Dionisi",
                "Lola",
                "dennislolas@gmail.com",
                "192.168.1.1",
                londonGeo.getLatitude(),
                londonGeo.getLongitude(),
                "London"
        );
        User user2 = new User(
                "Ornela",
                "Lola",
                "ornelalola@gmail.com",
                "192.168.1.2",
                athensGeo.getLatitude(),
                athensGeo.getLongitude(),
                "Athens"
        );
        User user3 = new User(
                "Kris",
                "Lola",
                "krislola@gmail.com",
                "192.168.1.3",
                munichGeo.getLatitude(),
                munichGeo.getLongitude(),
                "London"
        );

        User[] userArray = new User[2];
        userArray[0] = user1;
        userArray[1] = user2;

        User[] userArray2 = new User[1];
        userArray2[0] = user3;

        Mockito
                .when(restTemplate.getForEntity(
                        baseUrl + "/users", User[].class))
                .thenReturn(new ResponseEntity(userArray, HttpStatus.OK));

        Mockito
                .when(restTemplate.getForEntity(
                        baseUrl + "/city/London/users", User[].class))
                .thenReturn(new ResponseEntity(userArray2, HttpStatus.OK));

        List<User> users = service.getUsersInOrNear("London");
        Assertions.assertEquals(2, users.size());
    }
}
