package org.shest.mapperreducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CrossCorrelationV1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        do {
            line = reader.readLine();
            String[] symbols = line.trim().split("\\s");
            for (String symbolI : symbols) {
                for (String symbolJ : symbols) {
                    if (!symbolI.equals(symbolJ)) {
                        System.out.println(symbolI + "," + symbolJ + "\t" + 1);
                    }
                }
            }
        } while (reader.ready());

    }

}
