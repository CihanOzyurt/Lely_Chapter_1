package GoRest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class Test2_Create_User extends Parent{
    @BeforeClass
    void Setup() {
        baseURI = "https://gorest.co.in/public/v1/users";
    }

    User newUser;

    @Test
    public void createUser(){
        newUser=new User();

        newUser.setEmail("deneme100@gmail.com");
        newUser.setName("test1");
        newUser.setGender("female");
        newUser.setStatus("active");

        Response body=
        given()
                .header("Authorization","Bearer 1db9c9b6c959682be7c96f74ca532c3cb0bd331f46b86a92602f8d319481b6f5")
                .contentType(ContentType.JSON)
                .body(newUser)
                .when()
                .post(baseURI)

                .then()
                .log().body()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .extract().response()
        ;
        String name=body.path("data.name");
        String email=body.path("data.email");
        String gender=body.path("data.gender");
        String status=body.path("data.status");

        Assert.assertEquals(name,"test1");
        Assert.assertEquals(email,"deneme100@gmail.com");
        Assert.assertEquals(gender,"female");
        Assert.assertEquals(status,"active");
    }

    @Test//(dependsOnMethods = "createUser",priority = 1) if needs we can add priority
    public void createUserNegative() {
        String message;
        newUser=new User();

        newUser.setEmail("deneme100@gmail.com");
        newUser.setName("test1");
        newUser.setGender("female");
        newUser.setStatus("active");

        message=
        given()
                .header("Authorization","Bearer 1db9c9b6c959682be7c96f74ca532c3cb0bd331f46b86a92602f8d319481b6f5")
                .contentType(ContentType.JSON)
                .body(newUser)
                .when()
                .post(baseURI)

                .then()
                .log().body()
                .statusCode(422)
                .contentType(ContentType.JSON)
                .extract().jsonPath().getString("data.message")
        ;
        System.out.println("message = " + message);
        Assert.assertEquals(message,("[has already been taken]"));
    }
}
