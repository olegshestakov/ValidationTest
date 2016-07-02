package org.shest.mapperreducer;

import java.util.Scanner;

public class Mapper {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int count = 1;

        while (scanner.hasNext()) {
            String text = scanner.next();
            System.out.println(text+"\t"+count);
        }

    }
}
