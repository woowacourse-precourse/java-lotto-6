package lotto.dto;

import lotto.constants.LottoPrize;

public record LottoResult(int matchingNumbers, boolean hasMatchingBonusNumber, int prizeAmount, int numberOfWins) {
    public static LottoResult of(LottoPrize lottoPrize, int numberOfWins) {
        return new LottoResult(lottoPrize.getMatchingNumbers(), lottoPrize.getHasMatchingBonusNumber(),
                lottoPrize.getPrizeAmount(), numberOfWins);
    }
}