package org.shest.relation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Projection {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        do {
            line = reader.readLine();
            String[] words = line.trim().split("\t");
            System.out.println(words[2]);
        } while (reader.ready());

    }

}
