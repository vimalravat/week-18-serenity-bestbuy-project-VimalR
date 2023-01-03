package com.bestbuy.bestbuyinfo;

import com.bestbuy.productinfo.StoreSteps;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;
@RunWith(SerenityRunner.class)
public class StoresCRUDTestWithSteps extends TestBase {

    static String name = "BestBuyStore";
    static String type = "MyPractise";
    static String address = "20th Street E";
    static String address2 = "London 1";
    static String city = "London";
    static String state = "MN";
    static String zip = "12345";
    static double lat = 44.879314;
    static double lng = -93.077156;
    static String hours = "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8";

    static int storeId;
    @Steps
    StoreSteps storeSteps;

    @Title("This will create a new product")
    @Test
    public void test001() {

        ValidatableResponse response = storeSteps.createProduct(name, type, address,
                address2, city, state,
                zip, lat, lng, hours);
        response.log().all().statusCode(201);


    }

    @Title("Verify if the product was added to the application")
    @Test
    public void test002() {


        HashMap<String, Object> productMap = storeSteps.getStoreInfoByName(name);
        Assert.assertThat(productMap, hasValue(name));
        storeId = (int) productMap.get("id");
    }

    @Title("Update the product information and verify the updated information")
    @Test
    public void test003() {
        name = name + "_updated";

        ValidatableResponse  response=  storeSteps.updateStore(storeId,name, type, address,
                        address2, city, state,
                        zip, lat, lng, hours);
              response.log().all().statusCode(200);
        HashMap<String, Object> productMap = storeSteps.getStoreInfoByName(name);
        Assert.assertThat(productMap, hasValue(name));
    }

    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test004() {
        storeSteps.deleteStore(storeId).statusCode(204);
        storeSteps.getStoreById(storeId).statusCode(404);
    }

}
