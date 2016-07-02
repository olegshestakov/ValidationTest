package org.shest.relation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Union {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line, last = "";

        do {
            line = reader.readLine();
            String[] words = line.trim().split("\t");
            if (last.equals(words[0])) {
                System.out.println(words[0]);
                last = words[0];
            } else {
                last = words[0];
            }
        } while (reader.ready());

    }

}
