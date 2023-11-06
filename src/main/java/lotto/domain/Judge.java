package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class Judge {
    public static Integer winningCount(Lotto lotto, List<Integer> winningNumbers) {
        List<Integer> numbers = lotto.getNumbers();
        Integer result = 0;
        HashMap<Integer, Boolean> match = new HashMap<>();

        winningNumbers.forEach((number) -> {
            match.put(number, true);
        });

        for (Integer number : numbers) {
            if (match.containsKey(number)) {
                result++;
            }
        }

        return result;
    }

    public static Boolean isBonusMatch(Lotto lotto, Integer bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();

        for (Integer number : numbers) {
            if (number == bonusNumber) {
                return true;
            }
        }

        return false;
    }

    public static Enum<Ranking> resultPerLotto(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        Integer winningCount = winningCount(lotto, winningNumbers);
        Boolean bonusMatch = isBonusMatch(lotto, bonusNumber);

        if (winningCount == 3) {
            return Ranking.FIFTH;
        }
        if (winningCount == 4) {
            return Ranking.FOURTH;
        }
        if (winningCount == 5) {
            if (!bonusMatch) {
                return Ranking.THIRD;
            }
            return Ranking.SECOND;
        }
        if (winningCount == 6) {
            return Ranking.FIRST;
        }
        return Ranking.NONE;
    }
}
