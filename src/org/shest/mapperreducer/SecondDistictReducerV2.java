package org.shest.mapperreducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SecondDistictReducerV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line, last = "";
        Map<String, Integer> times = new HashMap<>();

        do {
            line = reader.readLine();
            String[] words = line.trim().split("\\t");
            if (!last.equals(line)) {
                if (!times.containsKey(words[1])) {
                    times.put(words[1], 0);
                }
                Integer value = times.get(words[1]);
                value++;
                times.put(words[1], value);
            }
            last = line;
        } while (reader.ready());

        for (String key : times.keySet()) {
            System.out.println(key + "\t" + times.get(key));
        }

    }

}
