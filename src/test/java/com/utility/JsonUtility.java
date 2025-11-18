package com.utility;

import com.ui.pojos.Config;
import com.ui.pojos.Environment;
import com.constants.Env;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtility {

    //to read json file

    public static Environment readJSON(Env env) {
        Gson gson = new Gson();
        FileReader fileReader;
        File jsonFile = new File(System.getProperty("user.dir")+"/config/config.json");
        try {
             fileReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Config config = gson.fromJson(fileReader, Config.class);
        Environment environment= config.getEnvironments().get("QA");
        return environment;

    }
}
