package GoRest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class Test1_DataId_Control extends Parent{

    @Test
    public void dataId_Control() {
        ArrayList<Integer> idList=
            given()
                    .spec(requestSpecs)

                    .when()
                    .get(baseURI)

                    .then()
                    .spec(responseSpecs200)
                    .extract().path("data.id")
            ;
        System.out.println("idList as Integer = " + idList);

        for (Integer i:  idList) {
            String strNumber=Integer.toString(i);

            Assert.assertEquals(strNumber.length(),4);
            Assert.assertNotNull(strNumber);
        }
    }










    //    RequestSpecification requestSpecs;
//    ResponseSpecification responseSpecs;
//    @BeforeClass
//    void Setup() {
//
//        baseURI ="https://gorest.co.in/public/v1/users";
//        requestSpecs = new RequestSpecBuilder()
//                .log(LogDetail.URI)
//                .setAccept(ContentType.JSON)
//                .build();
//
//        responseSpecs = new ResponseSpecBuilder()
//                .expectStatusCode(200)
//                .expectContentType(ContentType.JSON)
//                .log(LogDetail.BODY)
//                .build();
//    }
}
