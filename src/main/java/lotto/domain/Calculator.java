package lotto.domain;

import java.util.List;

public class Calculator {
    public static int calculateReturn(int lottoCount, boolean isBonus) {
        int sum = 0;

        // 5개 일치, 보너스 볼 일치 (30,000,000원)
        if (isBonus && lottoCount == 5) {
            sum += 30000000;
            return sum;
        }

        // 3개 일치 (5,000원) - 1개
        // 4개 일치 (50,000원) - 0개
        // 5개 일치 (1,500,000원) - 0개
        // 6개 일치 (2,000,000,000원) - 0개
        switch (lottoCount) {
            case 3:
                sum += 5000;
                break;
            case 4:
                sum += 50000;
                break;
            case 5:
                sum += 1500000;
                break;
            case 6:
                sum += 2000000000;
                break;
        }

        return sum;
    }

    public static double calculateRateOfReturn(int returnTotalCash, int cash) {
        double ret = (double) returnTotalCash / cash;  // ret = 0.625 -> 62.5로 바뀌어야하니까,
        ret = ret * 100; // 백분율화 62.5 만약 62.56이면 -> 62.6, 62.54면 -> 62.5
        ret = Math.round(ret * 10) / 10.0;
        return ret;
    }
}
