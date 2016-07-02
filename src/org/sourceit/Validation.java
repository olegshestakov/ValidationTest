package org.sourceit;

public class Validation {

    private static long[] creditCards = new long[]{4716347184862961L, 4532899082537349L,
            4485429517622493L, 4320635998241421L, 4929778869082405L, 5256283618614517L,
            5507514403575522L, 5191806267524120L, 5396452857080331L, 5567798501168013L,
            6011798764103720L, 6011970953092861L, 6011486447384806L, 6011337752144550L,
            6011442159205994L, 4916188093226163L, 4916699537435624L, 4024607115319476L,
            4556945538735693L, 4532818294886666L, 5349308918130507L, 5156469512589415L,
            5210896944802939L, 5442782486960998L, 5385907818416901L, 6011920409800508L,
            6011978316213975L, 6011221666280064L, 6011285399268094L, 6011111757787451L,
            4024007106747875L, 4916148692391990L, 4916918116659358L, 4024007109091313L,
            4716815014741522L, 5370975221279675L, 5586822747605880L, 5446122675080587L,
            5361718970369004L, 5543878863367027L, 6011996932510178L, 6011475323876084L,
            6011358905586117L, 6011672107152563L, 6011660634944997L, 4532917110736356L,
            4485548499291791L, 4532098581822262L, 4018626753711468L, 4454290525773941L,
            5593710059099297L, 5275213041261476L, 5244162726358685L, 5583726743957726L,
            5108718020905086L, 6011887079002610L, 6011119104045333L, 6011296087222376L,
            6011183539053619L, 6011067418196187L, 4532462702719400L, 4420029044272063L,
            4716494048062261L, 4916853817750471L, 4327554795485824L, 5138477489321723L,
            5452898762612993L, 5246310677063212L, 5211257116158320L, 5230793016257272L,
            6011265295282522L, 6011034443437754L, 6011582769987164L, 6011821695998586L,
            6011420220198992L, 4716625186530516L, 4485290399115271L, 4556449305907296L,
            4532036228186543L, 4916950537496300L, 5188481717181072L, 5535021441100707L,
            5331217916806887L, 5212754109160056L, 5580039541241472L, 6011450326200252L,
            6011141461689343L, 6011886911067144L, 6011835735645726L, 6011063209139742L,
            379517444387209L, 377250784667541L, 347171902952673L, 379852678889749L,
            345449316207827L, 349968440887576L, 347727987370269L, 370147776002793L,
            374465794689268L, 340860752032008L, 349569393937707L, 379610201376008L,
            346590844560212L, 376638943222680L, 378753384029375L, 348159548355291L,
            345714137642682L, 347556554119626L, 370919740116903L, 375059255910682L,
            373129538038460L, 346734548488728L, 370697814213115L, 377968192654740L,
            379127496780069L, 375213257576161L, 379055805946370L, 345835454524671L,
            377851536227201L, 345763240913232L};

    public static int countDigits(long number) {
        int x = 0;
        if (number > 0)
            x = (int) Math.log10(number) + 1;
        return x;
    }

    public static long sumOfNumber(long number) {
        long sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static long eval(long[] creditCardDigits) {

        String mas = "";
        for (int i = 0; i < creditCardDigits.length; i++) {
            mas += Long.toString(creditCardDigits[i]);
        }
        System.out.println(mas);
        Long eval = new Long(mas);

        return eval;
    }

    public static long evalRev(long[] creditCardDigits) {
        long creditNumber = 0L;
        long multiply = 1L;
        for (int i = 0; i < creditCardDigits.length; i++) {
            creditNumber += creditCardDigits[i] * multiply;
            multiply *= 10;
        }
        return creditNumber;
    }

    public static long[] toDigits(long creditCard) {
        int count = countDigits(creditCard);
        long digits[] = new long[count];
        int index = --count;
        while (creditCard > 0) {
            digits[index] = creditCard % 10;
            creditCard /= 10;
            index--;
        }
        return digits;
    }

    public static long[] toDigitsReverse(long creditCard) {
        long[] digits = toDigits(creditCard);
        long[] reverseCopy = new long[digits.length];
        int index = digits.length - 1;
        for (int i = 0; i < reverseCopy.length; i++) {
            reverseCopy[i] = digits[index];
            index--;
        }
        return reverseCopy;
    }

    public static long[] doubleSecond(long[] creditCardDigits) {

        for (int i = 0; i < creditCardDigits.length; i = i + 2) {
            creditCardDigits[i] = creditCardDigits[i] * 2;
        }
        return creditCardDigits;
    }

    public static long sumDigits(long[] listOfDigits) {
        long sum = 0;
        for (int i = 0; i < listOfDigits.length; i++) {
            sum += sumOfNumber(listOfDigits[i]);
        }
        return sum;
    }

    public static boolean isValid(long creditCard) {
//        if ((sumDigits(toDigitsReverse(toDigits(creditCard)))/10 == 0)) {
//            System.out.println("true");
//            return true;}
//        else  return false;
        long[] digits = toDigitsReverse(creditCard);
        long[] doubleDigits = doubleSecond(digits);
        long sum = sumDigits(doubleDigits);
        return sum % 10 == 0;

    }


    public static int numValid(long[] creditCards) {
        int count = 0;
        for (int i = 0; i < creditCards.length; i++) {
            if (isValid(creditCards[i])) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int valid = numValid(creditCards);
        System.out.println(valid);

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
        test13();
        test14();
        test15();
        test16();
        test17();
        test18();
        test19();
        test20();
        test21();
        test22();
    }

    public static void test1() {
        long[] testDigits = toDigits(12321L);
        long[] assertData = {1L, 2L, 3L, 2L, 1L};
        for (int i = 0; i < testDigits.length; i++) {
            assert testDigits[i] == assertData[i] : "Test1 is not passed";
        }
    }

    public static void test2() {
        long[] testDigits = toDigits(-531L);
        assert testDigits.length == 0 : "Test2 is not passed";
    }

    public static void test3() {
        long[] testDigit = toDigits(0L);
        assert testDigit.length == 1 && testDigit[0] == 0 : "Test3 is not passed";
    }

    public static void test4() {
        long[] testDigits = toDigits(777L);
        long[] assertData = {7L, 7L, 7L};
        for (int i = 0; i < testDigits.length; i++) {
            assert testDigits[i] == assertData[i] : "Test4 is not passed";
        }
    }

    public static void test5() {
        long[] testDigits = toDigitsReverse(12321L);
        long[] assertData = {1L, 2L, 3L, 2L, 1L};
        for (int i = 0; i < testDigits.length; i++) {
            assert testDigits[i] == assertData[i] : "Test5 is not passed";
        }
    }

    public static void test6() {
        long[] testDigits = toDigitsReverse(12321L);
        long[] assertData = {1L, 2L, 3L, 2L, 1L};
        for (int i = 0; i < testDigits.length; i++) {
            assert testDigits[i] == assertData[i] : "Test5 is not passed";
        }
    }

    public static void test7() {
        long[] testDigits = toDigitsReverse(-531L);
        assert testDigits.length == 0 : "Test7 is not passed";
    }

    public static void test8() {
        long[] testDigits = toDigitsReverse(0L);
        assert testDigits.length == 1 && testDigits[0] == 0 : "Test8 is not passed";
    }

    public static void test9() {
        long[] testDigits = toDigitsReverse(777L);
        long[] assertData = {7L, 7L, 7L};
        for (int i = 0; i < testDigits.length; i++) {
            assert testDigits[i] == assertData[i] : "Test9 is not passed";
        }
    }

    public static void test10() {
        long[] testDigits = doubleSecond(new long[0]);
        assert testDigits.length == 0 : "Test10 is not passed";
    }

    public static void test11() {
        long[] testDigits = doubleSecond(new long[]{5L});
        assert testDigits.length == 1 && testDigits[0] == 5 : "Test11 is not passed";
    }

    public static void test12() {
        long[] testDigits = doubleSecond(new long[]{2L, 5L});
        long[] assertData = {2L, 10L};
        for (int i = 0; i < testDigits.length; i++) {
            assert testDigits[i] == assertData[i] : "Test12 is not passed";
        }
    }

    public static void test13() {
        long[] testDigits = doubleSecond(new long[]{1L, 0L, 1L, 0L, 1L});
        long[] assertData = {1L, 0L, 1L, 0L, 1L};
        for (int i = 0; i < testDigits.length; i++) {
            assert testDigits[i] == assertData[i] : "Test13 is not passed";
        }
    }

    public static void test14() {
        long testSum = sumDigits(new long[0]);
        assert testSum == 0 : "Test14 is not passed";
    }

    public static void test15() {
        long testSum = sumDigits(new long[]{-15L, 15L});
        assert testSum == 6 : "Test15 is not passed";
    }

    public static void test16() {
        long testSum = sumDigits(new long[]{-12L, 12L});
        assert testSum == 3 : "Test16 is not passed";
    }

    public static void test17() {
        long testSum = sumDigits(new long[]{0L, 0L, 0L});
        assert testSum == 0 : "Test17 is not passed";
    }

    public static void test18() {
        long testSum = sumDigits(new long[]{7L, 77L, 777L});
        assert testSum == 42 : "Test18 is not passed";
    }

    public static void test19() {
        boolean isValid = isValid(5256283618614517L);
        assert isValid == true : "Test19 is not passed";
    }

    public static void test20() {
        boolean isValid = isValid(4556945538735694L);
        assert isValid == false : "Test20 is not passed";
    }

    public static void test21() {
        boolean isValid = isValid(0000000000000000L);
        assert isValid == true : "Test21 is not passed";
    }

    public static void test22() {
        int valid = numValid(creditCards);
        assert valid == 94 : "Test22 is not passed";
    }

}
