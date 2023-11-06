package lotto.domain;

import java.util.Arrays;
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

    public static Ranking resultPerLotto(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
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

    public static List<Integer> result(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        List<Integer> result = Arrays.asList(0, 0, 0, 0, 0);

        for (Lotto lotto : lottos) {
            Ranking ranking = resultPerLotto(lotto, winningNumbers, bonusNumber);

            if (ranking != Ranking.NONE) {
                Integer index = ranking.rank() - 1;
                Integer count = result.get(index);

                result.set(index, count + 1);
            }
        }

        return result;
    }

    public static Double rateOfReturn(List<Integer> result, Integer price) {
        Double accumulate = 0d;

        for (Integer rank = result.size() - 1; rank >= 0; rank--) {
            Integer count = result.get(rank);
            Integer reward = Ranking.findRankingByRank(rank + 1).reward();

            accumulate += reward * count;
        }

        return accumulate / price * 100;
    }
}
