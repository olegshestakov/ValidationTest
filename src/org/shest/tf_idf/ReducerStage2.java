package org.shest.tf_idf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReducerStage2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line, lastWord = "";

        String output = "";
        int count = 0;

        do {
            line = reader.readLine().trim();
            String[] parts = line.split("\\t");
            String[] info = parts[1].split(";");
            if (!lastWord.isEmpty() && !lastWord.equals(parts[0])) {
                output = output.replace("$", "" + count);
                output = output.substring(0, output.lastIndexOf("\n"));
                System.out.println(output);
                count = 0;
                output = "";
            }
            output += parts[0] + "#" + info[0] + "\t" + info[1] + "\t" + "$\n";
            lastWord = parts[0];
            count++;

        } while (reader.ready());

        System.out.println(output.replace("$", "" + count));


    }

}
