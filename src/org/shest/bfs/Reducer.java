package org.shest.bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reducer {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line, lastVertex, lastDistance, lastAncestors;
        lastVertex = lastDistance = lastAncestors = "";

        int dmin = Integer.MAX_VALUE;

        do {
            line = reader.readLine().trim();
            String graph[] = line.split("\\t");
            String vertex = graph[0];
            String distance = graph[1];
            String ancestors = graph[2];

            if (!lastVertex.isEmpty() && !lastVertex.equals(vertex)) {
                if (lastDistance.equals("INF") && Integer.valueOf(vertex) - Integer.valueOf(lastVertex) == 1) {
                    lastDistance = dmin + 1 + "";
                }
                System.out.println(lastVertex + "\t" + lastDistance + "\t" + lastAncestors);
                lastDistance = "";
                lastAncestors = "";
            }
            lastVertex = vertex;
            lastDistance = getDistance(distance, lastDistance).isEmpty() ? distance : getDistance(distance, lastDistance);

            if (!lastDistance.equals("INF")) {
                dmin = Integer.valueOf(lastDistance);
            }

            lastAncestors = lastAncestors.contains(",") ? lastAncestors : ancestors;
        } while (reader.ready());

        System.out.println(lastVertex + "\t" + lastDistance + "\t" + lastAncestors);

    }

    private static String getDistance(String prototype, String defaultPrototype) {
//        if (!prototype.equals("INF")) {
//            if(!defaultPrototype.equals("INF") && !defaultPrototype.isEmpty())
//        }
        return prototype.equals("INF") ? ((!defaultPrototype.equals("INF") && !defaultPrototype.isEmpty()) ?
                (Integer.valueOf(defaultPrototype) + "") : defaultPrototype) :
                (!defaultPrototype.equals("INF") && !defaultPrototype.isEmpty()) &&
                        Integer.valueOf(prototype) < Integer.valueOf(defaultPrototype) ? prototype : defaultPrototype;
    }

}
