package lotto.util;

import lotto.constant.LottoGame;

public class Calculator {
    public static int divide(int num1, int num2) {
        return num1 / num2;
    }

    public static boolean isMultiple(int dividend, int divisor) {
        return dividend % divisor == 0;
    }

    public static double percentage(double num1, double num2) {
        return (num1 / num2) * 100;
    }

    public static String rounds(double num) {
        return String.format(LottoGame.DECIMAL_FORMAT, num);
    }
}
