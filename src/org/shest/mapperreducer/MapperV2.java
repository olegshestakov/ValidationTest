package org.shest.mapperreducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MapperV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;
        Map<String, Integer> wordCount = new HashMap<>();

        do {
            line = reader.readLine();
            String[] words = line.trim().split("\\s");
            for (String s : words) {
                if (!wordCount.containsKey(s)) {
                    wordCount.put(s, 0);
                }
                Integer value = wordCount.get(s);
                value++;
                wordCount.put(s, value);
            }
        } while (reader.ready());

        for (String key : wordCount.keySet()) {
            System.out.println(key + "\t" + wordCount.get(key));
        }

    }

}
