package com.cleptes.strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Hashtable;
import org.json.*;

public class configFileReader {
    public static Hashtable<String, String> parseConfig(String configPath) throws Exception{
        Hashtable<String, String> config = new Hashtable<String, String>();

        File file = new File(configPath);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        String str = new String(data, "UTF-8");

        JSONObject jsonConfig = new JSONObject(str);
        config.put("sourceFile",jsonConfig.getString("sourceFile").toString());
        config.put("destinationFile",jsonConfig.getString("destinationFile").toString());
        config.put("csvSeperator",jsonConfig.getString("csvSeperator").toString());

        return config;
    }
}
