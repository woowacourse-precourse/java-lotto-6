package lotto.domain;

// LottoPrice
// ### ☑️ 로또 당첨 금액 계산 기능
// - 사용자가 당첨된 로또의 총 금액을 계산한다.

import lotto.constant.LottoPrize;

public class LottoCalc {
    
    public void calculateLotto(int matchingCount, LottoResult lottoResult) {
        if (matchingCount == LottoPrize.FIRST_PRIZE.getNumberOfMatch()) {
            lottoResult.addSixCount();
        }
        if (matchingCount == LottoPrize.SECOND_PRIZE.getNumberOfMatch()) {
            lottoResult.addFiveBonusCount();
        }
        if (matchingCount == LottoPrize.THIRD_PRIZE.getNumberOfMatch()) {
            lottoResult.addFiveCount();
        }
        if (matchingCount == LottoPrize.FOURTH_PRIZE.getNumberOfMatch()) {
            lottoResult.addFourCount();
        }
        if (matchingCount == LottoPrize.FIFTH_PRIZE.getNumberOfMatch()) {
            lottoResult.addThreeCount();
        }
    }
}
