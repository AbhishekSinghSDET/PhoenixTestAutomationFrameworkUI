package com.ui.dataProviders;

import com.com.ui.pojos.TestData;
import com.com.ui.pojos.User;
import com.google.gson.Gson;
import com.utility.ExcelReaderUtility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider(){
        Gson gson = new Gson();
        FileReader fileReader;
        File testDataFile = new File(System.getProperty("user.dir")+"/testData/loginData.json");
        try {
             fileReader = new FileReader(testDataFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        TestData data = gson.fromJson(fileReader, TestData.class);
        List<Object[]> dataToReturn = new ArrayList<>();

        for(User user : data.getData()){
            dataToReturn.add(new Object[]{user});
        }

        return dataToReturn.iterator();
    }

    @DataProvider(name="LoginTestExcelDataProvider")
    public Iterator<User> loginExcelDataProvider() throws IOException, InvalidFormatException {
        return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
    }
}
