package com.cleptes.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class CsvWriter{
    private String filePath;
    private String csvSeparator;

    public CsvWriter(String filePath, String csvSeparator) {
        this.filePath = filePath;
        this.csvSeparator = csvSeparator;
    }

    public boolean writeCsvFile(List<String[]> listToWrite) throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        String stringToWrite = "";

        for (String[] item : listToWrite){
            stringToWrite = stringToWrite.concat(item[0]+csvSeparator+item[1]+"\n");
        }

        writer.write(stringToWrite);



        return true;
    }

}
