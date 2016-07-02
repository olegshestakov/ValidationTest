package org.shest.bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mapper {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        do {
            line = reader.readLine().trim();
            String graph[] = line.split("\\t");
            String distance = graph[1];
            String[] ancestors = graph[2].replaceAll(",", " ").replaceAll("[\\{\\}]", "").split(" ");
            System.out.println(line);
            for (String ancestor : ancestors) {
                if (!ancestor.trim().isEmpty())
                    System.out.println(ancestor + "\t" + getDistance(distance) + "\t{}");
            }
        } while (reader.ready());


    }

    private static String getDistance(String prototype) {
        return prototype.equals("INF") ? prototype : (Integer.valueOf(prototype) + 1) + "";
    }

}
