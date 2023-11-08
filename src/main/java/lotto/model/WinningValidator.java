package lotto.model;

import java.util.List;

public class WinningValidator {
    public int countMatchNumbers(List<Integer> winningNumbers, List<Integer> numbers) {
        int matchCount = 0;

        for(int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount ++;
            }
        }

        return matchCount;
    }

    public boolean checkWinningBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
