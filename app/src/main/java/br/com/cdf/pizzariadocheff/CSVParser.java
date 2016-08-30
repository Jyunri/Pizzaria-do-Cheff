package br.com.cdf.pizzariadocheff;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Jimy on 8/30/16.
 */
    public class CSVParser {
        InputStream inputStream;
        BufferedReader reader;

    public CSVParser(InputStream inputStream) {
            this.inputStream = inputStream;
            reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    //retorna a lista de strings
    public ArrayList read()
    {
        ArrayList array = new ArrayList<>();
        String csvLine;
        try {

            // throw away the header
            reader.readLine();

            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                array.add(row);
            }
        }catch (Exception e) {
            e.toString();
        }
        return array;
    }
}
