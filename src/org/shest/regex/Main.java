package org.shest.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        //<editor-fold desc="simple regular expression">
        // creation of regular expression
        testRegularExpressionAndPrintResult("lo", "I love Java");
        //</editor-fold>

        //<editor-fold desc="classes of regular expression">
        // only digits
//        testRegularExpressionAndPrintResult("\\d", "7(903)-123-45-67");
//
//        // only symbols and digits
//        testRegularExpressionAndPrintResult("\\w", "Call me on 7(903)-123-45-67");
//
//        // first space, then digits and symbols
//        testRegularExpressionAndPrintResult("\\s\\w", "Call me on 7(903)-123-45-67");
//
//        // the word boundary
//        testRegularExpressionAndPrintResult("\\bJava\\b", "I love Java");
//        testRegularExpressionAndPrintResult("\\bJava\\b", "I love Javascript");
//        testRegularExpressionAndPrintResult("Java", "I love Javascript");
//
//        // not digits
//        testRegularExpressionAndPrintResult("\\D", "I love Java8");
//
//        // not digits and symbols
//        testRegularExpressionAndPrintResult("\\W", "I love Java8.");
//
//        // not spaces
//        testRegularExpressionAndPrintResult("\\S", "I love Java8.");
//
//        // spaces in regular expression
//        testRegularExpressionAndPrintResult("\\d - \\d", "1-7");
//        testRegularExpressionAndPrintResult("\\d-\\d", "1-7");
//
//        // any symbol
//        testRegularExpressionAndPrintResult(".", "Any symbol    42, regex45, []");
//
//        // screening of special symbols
//        // special symbols [ \ ^ $ . | ? * + ( )
//        testRegularExpressionAndPrintResult("\\(.*\\)", "for(int i = 0; i < a.length; i++) {\nSystem.out.println(\"I love Java\")\n}");
//        testRegularExpressionAndPrintResult("\\{\n.*\n\\}", "for(int i = 0; i < a.length; i++) {\n\tSystem.out.println(\"I love Java\")\n}");
        //</editor-fold>

        //<editor-fold desc="Sets and ranges">
        // set
//        testRegularExpressionAndPrintResult("[fc]ar", "far car");
//
//        // ranges
//        testRegularExpressionAndPrintResult("x[0-9A-F][0-9A-F]", "Exception 0xAF");
//
//        // \d – the same [0-9],
//        // \w – the same [a-zA-Z0-9_],
//        // \s – the same [\t\n\v\f\r ]
//
//        // except ranges
//        testRegularExpressionAndPrintResult("[^\\d\\sA-Z]", "alice15@gmail.com");

        // [^аеуо] – any symbol, except 'a', 'e', 'y', 'o'.
        // [^0-9] – any symbol, except digits, the same - \D.
        // [^\s] – any non-space symbol, the same - \S.

        //</editor-fold>

        //<editor-fold desc="Quantification">
//        testRegularExpressionAndPrintResult("\\d{5}", "I'm 12345");
//        testRegularExpressionAndPrintResult("\\d{3,5}", "I'm 123 4 6786");
//        testRegularExpressionAndPrintResult("\\d{3,}", "I'm 123 4 6786");
//
//        // + one or more
//        testRegularExpressionAndPrintResult("\\d+", "+7(903)-123-45-67");
//
//        // ? zero or one
//        testRegularExpressionAndPrintResult("colou?r", "We can write color or colour (britain variant)");
//
//        // * zero or more
//        testRegularExpressionAndPrintResult("\\d0*", "100 10 1");
        //</editor-fold>

        //<editor-fold desc="Groups">
//        testRegularExpressionAndPrintResult("(go)+", "Gogogo");
//
//        // lazy quantificator +?, *?, ??
//        testRegularExpressionAndPrintResult("<(.+?)>", "<h1>Hello, World!!!</h1>");
        //</editor-fold>

    }

    private static void testRegularExpressionAndPrintResult(String regex, String strToTest) {

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(strToTest);

        String result = "";

        while (matcher.find()) {
            result += matcher.toMatchResult().group() + ", ";
        }

        if (result.trim().length() != 0) {
            result = result.substring(0, result.lastIndexOf(","));
            System.out.printf("regular expression - %s, result - %s \n", regex, result.trim());
        } else {
            System.out.printf("regular expression - %s, result - %s \n", regex, "No matches");
        }

    }

}
