package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class RankCalculator {
    public static LottoPrize calculateRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = lotto.compareWinningNumber(winningNumbers);
        boolean matchBonus = lotto.compareBonusNumber(bonusNumber);
        if (matchCount == 6) return LottoPrize.FIRST_PRIZE;
        if (matchCount == 5 && matchBonus) return LottoPrize.SECOND_PRIZE;
        if (matchCount == 5) return LottoPrize.THIRD_PRIZE;
        if (matchCount == 4) return LottoPrize.FOURTH_PRIZE;
        if (matchCount == 3) return LottoPrize.FIFTH_PRIZE;
        return LottoPrize.BLANK;
    }
}
