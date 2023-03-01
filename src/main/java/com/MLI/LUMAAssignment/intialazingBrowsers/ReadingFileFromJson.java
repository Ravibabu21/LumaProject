package com.MLI.LUMAAssignment.intialazingBrowsers;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFileFromJson {
    public String readFile(String attribute) throws Exception {
        JsonParser jsonParser = new JsonParser();

        FileReader read = new FileReader("C:\\Users\\Ravibabu Singavarapu\\IdeaProjects\\AssignmentOnLUMA\\TestData\\TestData.json");


        Object obj = jsonParser.parse (read);

        JsonObject jsonObject =(JsonObject) obj;
        String value =jsonObject.get(attribute).toString();
        return value;
    }
}
