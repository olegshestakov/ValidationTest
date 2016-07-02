package org.shest.mapperreducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistinctMapperV1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        do {
            line = reader.readLine();
            String[] words = line.trim().split("\\t");
            String[] symbols = words[1].split(",");
            printPair(words[0], symbols);
        } while (reader.ready());

    }

    private static void printPair(String line, String[] symbols) {
        for (String symbol : symbols) {
            System.out.println(line + "," + symbol + "\t" + 1);
        }
    }

}
