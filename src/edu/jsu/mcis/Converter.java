package edu.jsu.mcis;

import java.io.*;
import java.util.*;
import com.opencsv.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Converter {
    
    /*
    
        Consider the following CSV data:
        
        "ID","Total","Assignment 1","Assignment 2","Exam 1"
        "111278","611","146","128","337"
        "111352","867","227","228","412"
        "111373","461","96","90","275"
        "111305","835","220","217","398"
        "111399","898","226","229","443"
        "111160","454","77","125","252"
        "111276","579","130","111","338"
        "111241","973","236","237","500"
        
        The corresponding JSON data would be similar to the following (tabs and other whitespace
        have been added for clarity).  Note the curly braces, square brackets, and double-quotes!
        
        {
            "colHeaders":["ID","Total","Assignment 1","Assignment 2","Exam 1"],
            "rowHeaders":["111278","111352","111373","111305","111399","111160","111276","111241"],
            "data":[[611,146,128,337],
                    [867,227,228,412],
                    [461,96,90,275],
                    [835,220,217,398],
                    [898,226,229,443],
                    [454,77,125,252],
                    [579,130,111,338],
                    [973,236,237,500]
            ]
        }
    
    */
    
    @SuppressWarnings("unchecked")
    public static String csvToJson(String csvString) {
        
        String results = "";
        
        try {
            
            CSVReader reader = new CSVReader(new StringReader(csvString));
            List<String[]> full = reader.readAll();
            Iterator<String[]> iterator = full.iterator();
            
            StringWriter writer = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(writer, ',', '"', '\n');
            //String[] csvData;
            //csvData.put("colHeaders", colHeaders);
            // csvWriter.writeNext(csvData);
            
            JSONObject jsonObject = new JSONObject();
            
            // INSERT YOUR CODE HERE
            
            String[] cols = full.get(0);
            JSONArray colHeaders = new JSONArray();
            
            for(String field : cols){
                colHeaders.add(field);
            }
            
            ArrayList<String> rows;
            JSONArray rowHeaders = new JSONArray();
            rows = new ArrayList<>();
            
            for(int i =1; i < full.size(); i++){
                rows.add(full.get(i)[0]);
            }
            
            rowHeaders.addAll(rows);
            
            for(String report : rows){
                rowHeaders.add(report);
            }
            
            jsonObject.put("colHeaders", colHeaders);
            
            String[] csvData = null; 
            csvWriter.writeNext(csvData);
            csvString = writer.toString();
            
            
            String[] line = iterator.next();
            for (String field : line) { System.out.println(field); }
            
            
            
            //nested data structures, an array inside and array.
            //converted into Integers.
        }
            
         
        catch(IOException e) { return e.toString(); }
        
        return results.trim();
        
    }
    
    public static String jsonToCsv(String jsonString) {
        
        String results = "";
        
        try {
            
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject)parser.parse(jsonString);
            
            
            List<String[]> full = null; // (assume that this is filled with data)
            //Iterator<String[]> iterator = full.iterator();

            
            StringWriter writer = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(writer, ',', '"', '\n');
            
            // INSERT YOUR CODE HERE
            //same process as CSVtojson, just reversed
            
            JSONArray records = new JSONArray(); // Container for all records
            String[] record;

            /*while (iterator.hasNext()) { // Iterate through all records
                record = iterator.next(); // Get next record
                jsonObject = new JSONObject(); // Create new JSON object container
                
                for (int i = 0; i < headings.length; ++i) { // Iterate through column headings
                    jsonObject.put(headings[i], record[i]); // Pair headings with fields
                }
                records.add(jsonObject); // Add JSON object to JSONArray
            }
            jsonObject = new JSONObject();

            LinkedHashMap<String, String> JsonObject;
            JsonObject = new LinkedHashMap<>();
*/
            
        }
        
        catch(ParseException e) { return e.toString(); }
        
        return results.trim();
        
    }
	
}