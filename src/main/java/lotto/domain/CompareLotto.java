package lotto.domain;

import java.util.List;

public class CompareLotto {
    public static Prize calculate(Lotto lotto, List<Integer> winnerNumber, int bonusNumber){
        final int matchCount = lotto.countMatches(winnerNumber);
        final boolean bonus = lotto.contains(bonusNumber);
        return Prize.getResult(matchCount, bonus);
    }
}