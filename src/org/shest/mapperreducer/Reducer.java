package org.shest.mapperreducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reducer {

    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String last = "";
        int count = 0;

        String line = "";

        do {
            line = reader.readLine();
            String[] parts = line.split("\t");
            if (!last.isEmpty() && !last.equals(parts[0])) {
                System.out.println(last + "\t" + count);
                last = parts[0];
                count = 1;
            } else {
                last = parts[0];
                count++;
            }
        } while (reader.ready());

        System.out.println(last + "\t" + count);

    }

}
