package org.shest.mapperreducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MapperV1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        do {
            line = reader.readLine();
            String[] words = line.trim().split("\\s");
            Map<String, Integer> wordCount = new HashMap<>();
            for(String s : words) {
                if(!wordCount.containsKey(s)) {
                    wordCount.put(s, 0);
                }
                Integer value = wordCount.get(s);
                value++;
                wordCount.put(s, value);
            }
            for (String key : wordCount.keySet()) {
                System.out.println(key + "\t" + wordCount.get(key));
            }
        } while (reader.ready());

    }

}
