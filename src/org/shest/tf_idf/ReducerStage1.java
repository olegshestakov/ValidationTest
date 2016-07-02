package org.shest.tf_idf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReducerStage1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;
        String lastWord = "";
        String lastDoc = "";
        int count = 0;

        do {
            line = reader.readLine().trim();
            String[] parts = line.split("\\t");
            String word = parts[0].split("#")[0];
            String doc = parts[0].split("#")[1];
            if ((!lastDoc.isEmpty() && !lastWord.isEmpty()) && (!lastWord.equals(word) || !lastDoc.equals(doc))) {
                System.out.println(lastWord + "\t" + lastDoc + "\t" + count);
                count = 0;
            }
            lastDoc = doc;
            lastWord = word;
            count++;

        } while (reader.ready());

        System.out.println(lastWord + "\t" + lastDoc + "\t" + count);

    }

}
