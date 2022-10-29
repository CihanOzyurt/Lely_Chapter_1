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

        newUser.setEmail("uuumut@gmail.com");
        newUser.setName("test");
        newUser.setGender("male");
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




    }
//    class User {
//        private int id;
//        private String email;
//        private String name;
//        private String gender;
//        private String status;
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getGender() {
//            return gender;
//        }
//
//        public void setGender(String gender) {
//            this.gender = gender;
//        }
//
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
//        }
//
//        @Override
//        public String toString() {
//            return "User{" +
//                    "id=" + id +
//                    ", email='" + email + '\'' +
//                    ", name='" + name + '\'' +
//                    ", gender='" + gender + '\'' +
//                    ", status='" + status + '\'' +
//                    '}';
//        }
//    }

}
