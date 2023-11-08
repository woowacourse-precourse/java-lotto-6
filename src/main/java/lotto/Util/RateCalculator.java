package lotto.Util;

public class RateCalculator {

    public static double returnRate(int getPrize, int Cash) {
        //수익률(%) = (총 당첨금 / 총 구입금액) * 100
        double rate = (double) getPrize / Cash * 100;

        // 소수점 둘째 자리에서 반올림
        rate = Math.round(rate * 10) / 10.0;

        return rate;
    }
}
