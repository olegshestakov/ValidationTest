package org.shest.dejcstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RoundOne {

    private static int amountOfVertex;
    private static int[][] graph;
    private static List<Integer> paths = null;


    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;
        boolean init = false;
        int begin = 0;
        int end = 0;

        do {
            line = reader.readLine().trim();
            String info[] = line.split("\\s");
            if (info.length == 2 && !init) {
                amountOfVertex = Integer.valueOf(info[0]);
                graph = new int[Integer.valueOf(info[0])][Integer.valueOf(info[0])];
                paths = new ArrayList<>();
                for (int i = 0; i < amountOfVertex; i++) {
                    paths.add(Integer.MAX_VALUE - 1);
                }
                init = true;
                continue;
            } else if (info.length == 2) {
                begin = Integer.valueOf(info[0]) - 1;
                end = Integer.valueOf(info[1]) - 1;
                paths.set(begin, 0);
                continue;
            }
            int input = Integer.valueOf(info[0]);
            int output = Integer.valueOf(info[1]);
            int weight = Integer.valueOf(info[2]);
            graph[input - 1][output - 1] = weight;
        } while (reader.ready());

        dijkstra(begin, end);

    }

    private static void dijkstra(int begin, int end) {
        Integer[] Q = paths.toArray(new Integer[]{});

        while (!checkQ(Q)) {
            int u = extractMin(Q, paths);
            for (int v = 0; v < graph[u].length; v++) {
                if (!isUsed(Q, v) && graph[u][v] != 0 && paths.get(v) > paths.get(u) + graph[u][v]) {
                    paths.set(v, paths.get(u) + graph[u][v]);
                }
            }
        }

        System.out.println(paths.get(end) == 0 ?
                (begin == end ? 0 : -1) :
                (paths.get(end) == Integer.MAX_VALUE - 1 ? -1 : paths.get(end)));

    }

    private static int extractMin(Integer[] Q, List<Integer> paths) {
        int min = Integer.MAX_VALUE;
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < Q.length; i++) {
            if (Q[i] != null && min > paths.get(i)) {
                index = i;
                min = paths.get(i);
            }
        }
        Q[index] = null;
        return index;
    }

    private static boolean checkQ(Integer[] Q) {
        boolean used = true;
        for (Integer vertex : Q) {
            if (vertex != null) {
                return false;
            }
        }
        return used;
    }

    private static boolean isUsed(Integer[] Q, int index) {
        return Q[index] == null;
    }

}
