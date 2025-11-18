package com.utility;

import com.ui.pojos.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readExcelFile(String fileName) throws IOException, InvalidFormatException {
        File xlsxFile = new File(System.getProperty("user.dir")+"/testData/"+fileName);

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(xlsxFile);
        List<User> userList = new ArrayList<>();

        XSSFSheet xssfSheet = xssfWorkbook.getSheet("Sheet1");
        Iterator<Row> rowIterator = xssfSheet.iterator();
        rowIterator.next();  // skip column name

        while (rowIterator.hasNext()){
            Row row = rowIterator.next();

            Cell firstCell = row.getCell(0);
            Cell secondCell = row.getCell(1);
            User user = new User(firstCell.toString(),secondCell.toString());
            userList.add(user);
        }

        xssfWorkbook.close();
        return userList.iterator();
    }
}
