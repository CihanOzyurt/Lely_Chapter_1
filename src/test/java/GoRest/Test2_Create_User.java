package GoRest;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class Test2_Create_User extends Parent{
    @BeforeClass
    void Setup() {

        baseURI = "https://gorest.co.in/public/v1/users";
    }

    User newUser;
    int userID=0;

    @Test
    public void createUser(){
        newUser=new User();

        newUser.setEmail("abcmut@gmail.com");
        newUser.setName("test1");
        newUser.setGender("female");
        newUser.setStatus("active");

        userID=

        given()
                .header("Authorization","Bearer 1db9c9b6c959682be7c96f74ca532c3cb0bd331f46b86a92602f8d319481b6f5")
                //.spec(requestSpecs)
                .contentType(ContentType.JSON)
                .body(newUser)
                .log().body()
                .when()
                .post(baseURI)

                .then()
                .log().body()
                .statusCode(201)
                .contentType(ContentType.JSON)
                //.spec(responseSpecs201)
                .extract().jsonPath().getInt("data.id")

        ;
        System.out.println("userID = " + userID);




    }
}
