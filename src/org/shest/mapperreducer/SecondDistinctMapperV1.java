package org.shest.mapperreducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondDistinctMapperV1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        do {
            line = reader.readLine();
            String[] words = line.trim().split(",");
            System.out.println(words[1] + "\t" + 1);
        } while (reader.ready());

    }

}
