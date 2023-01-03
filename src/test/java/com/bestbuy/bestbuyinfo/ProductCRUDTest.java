package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;

public class ProductCRUDTest extends TestBase {
 /*   static String name = "BestBuy" + TestUtils.getRandomValue();
    static String type = "Practise";
    static String price = "04";
    static String shipping = "Not Applicable";
    static String upc = "1234567890";
    static String description = "New";
    static String manufacturer = "Vimal";
    static String model = TestUtils.getRandomValue() + "1212";
    static int productId;

    @Title("This will create a new product")
    @Test
    public void test001() {


        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);

        SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(productPojo)
                .when()
                .post()
                .then().log().all().statusCode(201);
    }
    @Title("Verify if the product was added to the application")
    @Test
    public void test002() {
        String p1 = "findAll{it.name == '";
        String p2 = "'}.get(0)";

        HashMap<String, Object> productMap = SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_PRODUCT)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
        Assert.assertThat(productMap, hasValue(name));
        productId = (int) productMap.get("id");
    }
    @Title("Update the product information and verify the updated information")
    @Test
    public void test003() {
        name = name + "_updated";


        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("productID", productId)
                .body(productPojo)
                .when()
                .put(EndPoints.UPDATE_PRODUCT_BY_ID)
                .then().log().all().statusCode(200);

        String p1 = "findAll{it.name == '";
        String p2 = "'}.get(0)";
        HashMap<String, Object> productMap = SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_PRODUCT)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
        Assert.assertThat(productMap, hasValue(name));
    }
    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test004() {
        SerenityRest.given().log().all()
                .pathParam("productID", productId)
                .when()
                .delete(EndPoints.DELETE_PRODUCT_BY_ID)
                .then().statusCode(204);

        SerenityRest.given().log().all()
                .pathParam("productID", productId)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCT_BY_ID)
                .then()
                .statusCode(404);
    }*/

}
