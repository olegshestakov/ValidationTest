package org.shest.tf_idf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MapperStage2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        do {
            line = reader.readLine().trim();
            String[] parts = line.split("\\t");
            System.out.println(parts[0] + "\t" + parts[1] + ";" + parts[2] + ";" + 1);
        } while (reader.ready());


    }

}
