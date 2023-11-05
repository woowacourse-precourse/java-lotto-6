package lotto.domain;

import java.util.List;

public class MatchLotto {
    public static Prize calculate(Lotto lotto, List<Integer> winnerNumber, int bonusNumber){
        final int matchCount = countMatches(lotto, winnerNumber);
        final boolean bonus = containBonusNumber(lotto, bonusNumber);
        return Prize.getResult(matchCount, bonus);
    }

    private static int countMatches(Lotto lotto, List<Integer> winnerNumber) {
        return (int) lotto.getLotto().stream()
                .filter(winnerNumber::contains)
                .count();
    }

    private static boolean containBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getLotto().contains(bonusNumber);
    }
}