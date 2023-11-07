package lotto.service;

public class MakeEarningResult {
    private static final String START = "총 수익률은 ";
    private static final String END = "%입니다.";

    private static final String EXPRESS_DOT = "%.1f";
    public static String calRate(long earningRate, int money) {
        double rate = (double) earningRate / money;
        // 소수점 첫째자리까지 표현 + 반올림
        return START + String.format(EXPRESS_DOT, rate * 100) + END;
    }
}
