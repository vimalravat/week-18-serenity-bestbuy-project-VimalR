package com.bestbuy.productinfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.StorePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class StoreSteps {
    @Step("Creating student with name : {0}, type: {1}, email: {2}, address: {3}, address2: {4}, city: {5}, state: {6}, zip: {7}, lat: {8},lng: {9} and hours: {10}")
    public ValidatableResponse createProduct(String name, String type, String address,
                                             String address2, String city, String state,
                                             String zip, double lat, double lng, String hours) {
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

       return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .post(EndPoints.GET_ALL_STORE)
                .then();
    }
    @Step("Getting the store information with stored ID: {0}")
    public HashMap<String, Object> getStoreInfoByName(String name) {
        String p1="data.findAll{it.name=='";
        String p2="'}.get(0)";

        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_STORE)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);

    }
    @Step ("Updating store with name : {0}, type: {1}, email: {2}, address: {3}, address2: {4}, city: {5}, state: {6}, zip: {7}, lat: {8},lng: {9} and hours: {10}")
    public ValidatableResponse updateStore(int storeId, String name, String type, String address,
                                             String address2, String city, String state,
                                             String zip, double lat, double lng, String hours) {
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
       return SerenityRest.given().log().all()
               .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .pathParam("storeId", storeId)
                .body(storePojo)
                .when()
                .put(EndPoints.UPDATE_STORE_BY_ID)
                .then();
    }
    @Step("Deleting student information with studentId: {0}")
    public ValidatableResponse deleteStore(int storeId) {
        return SerenityRest.given().log().all()
                .pathParam("storeId", storeId)
                .when()
                .delete(EndPoints.DELETE_STORE_BY_ID)
                .then();
    }

    @Step("Getting student information with studentId: {0}")
    public ValidatableResponse getStoreById(int storeId){
        return SerenityRest.given().log().all()
                .pathParam("storeId", storeId)
                .when()
                .get(EndPoints.DELETE_STORE_BY_ID)
                .then();
    }

}
