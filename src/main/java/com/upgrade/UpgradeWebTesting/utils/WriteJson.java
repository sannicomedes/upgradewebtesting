package com.upgrade.UpgradeWebTesting.utils;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteJson {

    public static void setJson(File jsonFile, JSONObject json) {

        try (FileWriter file = new FileWriter(jsonFile)) {

            file.write(json.toJSONString());

        } catch (IOException e) {
            e.printStackTrace();
        }




    }


}
