package com.cleptes.strings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private String file_name;
    private String csvSplitBy;

    public CsvReader(String file_name, String csvSplitBy) {
        this.file_name = file_name;
        this.csvSplitBy = csvSplitBy;
    }

    public List<String[]> readFile() {
        List<String[]> nameCodeList = new ArrayList<String[]>();//

        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(file_name));
            while ((line = br.readLine()) != null) {
                String[] tmp = null;
                tmp = line.split(csvSplitBy);
                nameCodeList.add(tmp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return nameCodeList;
    }
}
