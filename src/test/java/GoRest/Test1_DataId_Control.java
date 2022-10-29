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
}
