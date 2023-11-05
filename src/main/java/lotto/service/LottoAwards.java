package lotto.service;

import lotto.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;

import java.util.Arrays;
import java.util.List;

public class LottoAwards {
    public static int CAN_BONUS_NUMBER_CONDITION = 5;
    public static Rank awards(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = findMatchNumber(lotto, winningNumber.getWinnerLotto().getNumbers());

        boolean useBonus = false;
        if (matchCount == CAN_BONUS_NUMBER_CONDITION) {
            useBonus = lotto.numberCheck(winningNumber.getBonusNumber());
        }

        return getRank(matchCount, useBonus);
    }
    private static Rank getRank(int matchCount, boolean useBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .filter(rank -> rank.isBonusCheck() == useBonus)
                .findAny()
                .orElse(Rank.NO);
    }
    private static int findMatchNumber(Lotto lotto, List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(lotto::numberCheck)
                .count();
    }
}
