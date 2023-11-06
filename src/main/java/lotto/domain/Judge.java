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
}
