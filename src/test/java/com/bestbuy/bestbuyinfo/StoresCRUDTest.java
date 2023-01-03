package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;

public class StoresCRUDTest extends TestBase {

   /* static String name = "BestBuyStore" + TestUtils.getRandomValue();
    static String type = "MyPractise";
    static String address = TestUtils.getRandomValue() + "20th Street E";
    static String address2 = " ";
    static String city = "London";
    static String state = "MN";
    static String zip = "12345";
    static double lat = 44.879314;
    static double lng = -93.077156;
    static String hours = "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8";

    static int storeId;

    @Title("This will create a new Store information")
    @Test
    public void test001() {

        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);

        SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .post()
                .then().log().all().statusCode(201);
    }
    @Title("Verify if the product was added to the application")
    @Test
    public void test002() {
        String p1 = "findAll{it.name == '";
        String p2 = "'}.get(0)";

        HashMap<String, Object> storeMap = SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_STORE)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
        Assert.assertThat(storeMap, hasValue(name));
        storeId = (int) storeMap.get("id");
    }
    @Title("Update the product information and verify the updated information")
    @Test
    public void test003() {
        name = name + "_updated";

        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);
        SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("storeId", storeId)
                .body(storePojo)
                .when()
                .put(EndPoints.UPDATE_STORE_BY_ID)
                .then().log().all().statusCode(200);

        String p1 = "findAll{it.name == '";
        String p2 = "'}.get(0)";
        HashMap<String, Object> storeMap = SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_STORE)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
        Assert.assertThat(storeMap, hasValue(name));
    }
    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test004() {
        SerenityRest.given().log().all()
                .pathParam("storeId", storeId)
                .when()
                .delete(EndPoints.DELETE_STORE_BY_ID)
                .then().statusCode(204);

        SerenityRest.given().log().all()
                .pathParam("storeId", storeId)
                .when()
                .get(EndPoints.GET_SINGLE_STORE_BY_ID)
                .then()
                .statusCode(404);
    }*/

}
