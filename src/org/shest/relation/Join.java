package org.shest.relation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Join {


    public static void main(String[] args) throws IOException {
    BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        Map<String, List<String>> sets = new HashMap<>();

        do {
            line = reader.readLine();
            String[] words = line.trim().split("\\t");
            if (sets.size() == 0) {
                sets.put(words[0], new ArrayList<>());
            } else if (sets.size() == 1 & sets.get(words[0]) == null) {
                processRecord(sets);
                sets.clear();
                sets.put(words[0], new ArrayList<>());
            }
            List<String> record = sets.get(words[0]);
            record.add(words[1]);
        } while (reader.ready());

        processRecord(sets);

    }

    private static void processRecord(Map<String, List<String>> record) {
        for (String user : record.keySet()) {
            List<String> queries = new ArrayList<>();
            List<String> urls = new ArrayList<>();
            List<String> records = record.get(user);
            for (String rec : records) {
                if (rec.contains("query")) {
                    queries.add(rec);
                } else if (rec.contains("url")) {
                    urls.add(rec);
                }
            }

            for (int i = 0; i < queries.size(); i++) {
                for (int j = 0; j < urls.size(); j++) {
                    System.out.println(user + "\t" + queries.get(i).split(":")[1] + "\t" + urls.get(j).split(":")[1]);
                }
            }
        }
    }

}
