package com.example.selfcert.controllers;

import com.example.selfcert.framework.FunctionalTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Tag("functional")
class UserControllerTest extends FunctionalTest {

    @Test
    void getUserInformation() {
        RestAssured.
                when().get(String.format("http://localhost:%d/users/1", port)).
                then().
                statusCode(200).
                body("id", equalTo(1)).
                body("name", equalTo("John Wick")).
                body("email", equalTo("john@wick.com")).
                body("darkTheme", notNullValue()).
                body("longitude", isA(Float.class)).
                body("latitude", isA(Float.class))
        ;
    }
}