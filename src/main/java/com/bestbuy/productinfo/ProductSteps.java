package com.bestbuy.productinfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.ProductPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ProductSteps {
    @Step("Creating student with name : {0}, type: {1}, email: {2}, price: {3}, shipping: {4}, upc: {5}, description: {6}, manufacturer: {7} and model: {8}")
    public ValidatableResponse createProduct(String name, String type, String price,
                                             String shipping,String upc, String description,
                                             String manufacturer,String model) {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(productPojo)
                .when()
                .post()
                .then();

    }
    @Step("Getting the student information with firstName: {0}")
    public HashMap<String, Object> getProductInfoByName(String name) {
        String p1 = "findAll{it.name == '";
        String p2 = "'}.get(0)";

        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_PRODUCT)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);

    }
    @Step("Creating product with name : {0}, type: {1}, email: {2}, price: {3}, shipping: {4}, upc: {5}, description: {6}, manufacturer: {7} and model: {8}")
    public ValidatableResponse updateProduct(int productId, String name, String type, String price,
                                             String shipping,String upc, String description,
                                             String manufacturer,String model){
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
       return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("productID", productId)
                .body(productPojo)
                .when()
                .put(EndPoints.UPDATE_PRODUCT_BY_ID)
                .then();
    }
    @Step("Getting the student information with firstName: {0}")
    public HashMap<String, Object> getStudentInfoByFirstName(String name) {
        String p1 = "findAll{it.name == '";
        String p2 = "'}.get(0)";
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_PRODUCT)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
    }
    @Step("Deleting student information with studentId: {0}")
    public ValidatableResponse deleteProduct(int productId) {
        return SerenityRest.given().log().all()
                .pathParam("productID", productId)
                .when()
                .delete(EndPoints.DELETE_PRODUCT_BY_ID)
                .then();
    }

    @Step("Getting student information with studentId: {0}")
    public ValidatableResponse getProductById(int productId){
        return SerenityRest.given().log().all()
                .pathParam("productID", productId)
                .when()
                .get(EndPoints.DELETE_PRODUCT_BY_ID)
                .then();
    }

}
