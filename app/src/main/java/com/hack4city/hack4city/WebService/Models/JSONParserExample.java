package com.hack4city.hack4city.WebService.Models;
import com.google.gson.*;

public class JSONParserExample {
    public TokenModel myTokenModel;
    public JSONParserExample() {
        String myString = "{\n" +
                "access_token: \"<ornek_token_bilgisi>\",\n" +
                "token_type: \"bearer\",\n" +
                "expires_in: 86399\n" +
                "}";

        myTokenModel = new Gson().fromJson(myString,TokenModel.class);
    }
}
