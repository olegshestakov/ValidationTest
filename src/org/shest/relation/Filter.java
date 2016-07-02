package org.shest.relation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Filter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        do {
            line = reader.readLine();
            String[] words = line.trim().split("\t");
            if (words[1].equals("user10")) {
                System.out.println(line);
            }
        } while (reader.ready());

    }

}
