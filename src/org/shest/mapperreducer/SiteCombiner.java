package org.shest.mapperreducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SiteCombiner {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line, last = "";
        int count = 0;
        int sum = 0;

        do {
            line = reader.readLine();
            String[] parts = line.split("\t");
            if (!last.isEmpty() && !last.equals(parts[0])) {
                System.out.println(last + "\t" + sum + ";" + count);
                last = parts[0];
                sum = Integer.valueOf(parts[1].split(";")[0]);
                count = 1;
            } else {
                last = parts[0];
                sum += Integer.valueOf(parts[1].split(";")[0]);
                count++;
            }
        } while (reader.ready());

        System.out.println(last + "\t" + sum + ";" + count);
    }

}
