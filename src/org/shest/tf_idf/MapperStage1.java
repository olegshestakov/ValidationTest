package org.shest.tf_idf;

import javafx.animation.PathTransition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MapperStage1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        do {
            line = reader.readLine();
            line = line.trim();
            String numOfDoc = line.substring(0, line.indexOf(':'));
            String words = line.substring(line.indexOf(':') + 1);
            words = words.trim();
            words = words.replaceAll("[\\t:;!?,.()\\[\\]\\{\\}@#%=-]", " ");
            for (String word : words.split("\\s")) {
                if (word.trim().length() > 0)
                    System.out.println(word + "#" + numOfDoc + "\t" + 1);
            }
        } while (reader.ready());

    }

}
