package lotto.domain;

import lotto.domain.Constant.LottoCashConstant;

public class Calculator {
    public static int calculateReturn(int lottoCount, boolean isBonus) {
        int sum = 0;

        // 5개 일치, 보너스 볼 일치 (30,000,000원)
        if (isBonus && lottoCount == 5) {
            sum += LottoCashConstant.match5AndBonus.getCash();
            return sum;
        }

        // 3개 일치 (5,000원) - 1개
        // 4개 일치 (50,000원) - 0개
        // 5개 일치 (1,500,000원) - 0개
        // 6개 일치 (2,000,000,000원) - 0개
        switch (lottoCount) {
            case 3:
                sum += LottoCashConstant.match3.getCash();
                break;
            case 4:
                sum += LottoCashConstant.match4.getCash();
                break;
            case 5:
                sum += LottoCashConstant.match5.getCash();
                break;
            case 6:
                sum += LottoCashConstant.match6.getCash();
                break;
        }

        return sum;
    }

    public static double calculateRateOfReturn(int returnTotalCash, int cash) {
        double ret = (double) returnTotalCash / cash;  // ret = 0.625 -> 62.5로 바뀌어야하니까,
        ret = ret * 100; // 백분율화 62.5
        ret = Math.round(ret * 10) / 10.0; // 만약 62.56이면 -> 62.6, 62.54면 -> 62.5
        return ret;
    }
}
