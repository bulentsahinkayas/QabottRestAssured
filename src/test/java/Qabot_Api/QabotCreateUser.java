package Qabot_Api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.DBUtilityJDBC;

import java.sql.ResultSet;
import java.util.List;

public class QabotCreateUser {
    @Test
    public void createAccount(){
        RestAssured.baseURI = "https://qabott-server.herokuapp.com/users";
        //Request object
        RequestSpecification httpRequest = RestAssured.given();


        // Request payload sending along with post request
        JSONObject requestParam = new JSONObject();
        String fullName = "Erhan Koca";
        String email = "abc58@email.com";
        String password = "abc1234";

//        requestParam.put("fullName",fullName);
//        requestParam.put("email",email);
//        requestParam.put("password",password);
//        httpRequest.header("Content-Type","application/json");
//
//        httpRequest.body(requestParam.toJSONString());
//
//        //Response object
//        Response response = httpRequest.request(Method.POST,"/create_user");
//
//        // print response
//        String responseBody = response.getBody().asString();
//        System.out.println("Response Body is: "+responseBody  );
//
//        // status code
//
//        int statusCode = response.getStatusCode();
//        System.out.println("Status Code is: "+statusCode);
//        Assert.assertEquals(statusCode,201);
//
//        //success code
//        String successCode = response.jsonPath().get("success");
//        Assert.assertEquals(successCode,"Hooray!!! An account for Erhan Koca created successfully!");

        DBUtilityJDBC dataBase = new DBUtilityJDBC();
        String query = "select * from users where email='"+email+"'";
        List<Object> result = dataBase.getColumnData(query,"email");
        System.out.println(result.toString());
        String actualEmail = result.get(0).toString();
        Assert.assertEquals(actualEmail,email);

    }

}
