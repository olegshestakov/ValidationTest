package org.shest.mapperreducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DistinctReducerV1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line, last = "";

        do {
            line = reader.readLine();
            String[] words = line.trim().split("\\t");
            if (!last.isEmpty() && !last.equals(words[0])) {
                System.out.println(last);
                last = words[0];
            } else {
                last = words[0];
                continue;
            }
        } while (reader.ready());

        System.out.println(last);

    }

}
