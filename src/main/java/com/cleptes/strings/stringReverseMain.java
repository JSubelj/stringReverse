package com.cleptes.strings;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Hello world!
 *
 */
public class stringReverseMain {
    public static void main( String[] args ) throws Exception {
        Hashtable<String, String> config = configFileReader.parseConfig(args[0]);


        CsvReader csvReader = new CsvReader(config.get("sourceFile"),config.get("csvSeperator"));
        List<String[]> org = csvReader.readFile();
        List<String[]> changed = new ArrayList<String[]>();
        for (String[] s : org) {
            String reversedCode = new StringBuilder(s[1]).reverse().toString();
            String[] tmp = {s[0],reversedCode};
            changed.add(tmp);
            System.out.println("old: " + s[0] + " " + s[1]);
            System.out.println("new: " + tmp[0] + " " + tmp[1]+"\n");

        }

        CsvWriter csvWriter = new CsvWriter(config.get("destinationFile"),config.get("csvSeperator"));

        csvWriter.writeCsvFile(changed);


    }
}
