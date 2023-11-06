package lotto.domain;

import java.util.List;

public class Judge {
    public int countMatchingNumbers(List<Lotto> numbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : winningNumbers) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean matchesBonusNumber(List<Lotto> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

}
