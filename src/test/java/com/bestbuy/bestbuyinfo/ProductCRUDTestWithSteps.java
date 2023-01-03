package com.bestbuy.bestbuyinfo;

import com.bestbuy.productinfo.ProductSteps;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
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
public class ProductCRUDTestWithSteps extends TestBase {
    static String name = "BestBuy" + TestUtils.getRandomValue();
    static String type = "Practise";
    static String price = "04";
    static String shipping = "Not Applicable";
    static String upc = "1234567890";
    static String description = "New";
    static String manufacturer = "Vimal";
    static String model = TestUtils.getRandomValue() + "1212";
    static int productId;
    @Steps
    ProductSteps productSteps;

    @Title("This will create a new product")
    @Test
    public void test001() {

        ValidatableResponse response = productSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model);
        response.log().all().statusCode(201);
        response.extract().path("id");

    }

    @Title("Verify if the product was added to the application")
    @Test
    public void test002() {
        String p1 = "findAll{it.name == '";
        String p2 = "'}.get(0)";

        HashMap<String, Object> productMap = productSteps.getProductInfoByName(name);
        Assert.assertThat(productMap, hasValue(name));
        productId = (int) productMap.get("id");
    }

    @Title("Update the product information and verify the updated information")
    @Test
    public void test003() {
        name = name + "_updated";

        productSteps.updateProduct(productId, name, type, price, shipping, upc, description, manufacturer, model)
                .log().all().statusCode(200);
        HashMap<String, Object> productMap = productSteps.getProductInfoByName(name);
        Assert.assertThat(productMap, hasValue(name));
    }

    @Title("Delete the product and verify if the product is deleted!")
    @Test
    public void test004() {
        productSteps.deleteProduct(productId).statusCode(204);
        productSteps.getProductById(productId).statusCode(404);
    }

}
