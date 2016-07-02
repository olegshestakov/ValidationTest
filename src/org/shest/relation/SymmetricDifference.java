package org.shest.relation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymmetricDifference {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        Map<String, List<String>> sets = new HashMap<>();

        do {
            line = reader.readLine();
            String[] words = line.trim().split("\\s");
            String key = words[0];
            if (!sets.containsKey(key)) {
                sets.put(key, new ArrayList<>());
            }
            List<String> value = sets.get(key);
            value.add(words[1]);
        } while (reader.ready());

        for (String key : sets.keySet()) {
            if (sets.get(key).size() == 1 && (sets.get(key).get(0).equals("A") || sets.get(key).get(0).equals("B"))) {
                System.out.println(key);
            }
        }

    }

}
