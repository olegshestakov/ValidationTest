package org.shest.mapperreducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CrossCorellationV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        do {
            line = reader.readLine();
            String[] symbols = line.trim().split("\\s");
            for (String symbolI : symbols) {
                Map<String, Map<String, Integer>> stripes = new HashMap<>();
                for (String symbolJ : symbols) {
                    if (!symbolI.equals(symbolJ)) {
                        if (!stripes.containsKey(symbolI)) {
                            stripes.put(symbolI, new HashMap<>());
                        }

                        Map<String, Integer> stripeElement = stripes.get(symbolI);

                        if (!stripeElement.containsKey(symbolJ)) {
                            stripeElement.put(symbolJ, 0);
                        }

                        Integer value = stripeElement.get(symbolJ);
                        value++;
                        stripeElement.put(symbolJ, value);
                    }
                }
                for (String stripeKey : stripes.keySet()) {
                    String output = stripeKey + "\t";
                    for (String s : stripes.get(stripeKey).keySet()) {
                        output += s + ":" + stripes.get(stripeKey).get(s) + ",";
                    }

                    output = output.substring(0, output.length() - 1);
                    System.out.println(output);
                }
            }

        } while (reader.ready());

    }

}
