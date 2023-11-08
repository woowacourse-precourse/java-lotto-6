package lotto.domain;

// LottoRate
// ### ☑️ 수익률 계산 기능
// - 사용자의 구입 금액과 당첨된 경우 받을 수 있는 금액에 대하여 수익률을 계산하여 리턴한다.

import lotto.constant.LottoPrize;

public class LottoRate {
    
    public static String calculateRate(int paidMoney, LottoResult lottoResult) {
        int totalMoney = 0;
        double result;

        totalMoney += LottoPrize.FIRST_PRIZE.getPrice() * lottoResult.getSixCount();
        totalMoney += LottoPrize.SECOND_PRIZE.getPrice() * lottoResult.getFiveBonusCount();
        totalMoney += LottoPrize.THIRD_PRIZE.getPrice() * lottoResult.getFiveCount();
        totalMoney += LottoPrize.FOURTH_PRIZE.getPrice() * lottoResult.getFourCount();
        totalMoney += LottoPrize.FIFTH_PRIZE.getPrice() * lottoResult.getThreeCount();

        result = (double) totalMoney / paidMoney;
        result = roundRate(result);

        return String.format("%.1f", result);
    }

    public static double roundRate(double rate) {
        return Math.round(rate * 10) / 10.0;
    }

}
