package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private int countMatchingNumbers(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    private int checkBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return 1;
        }
        return 0;

    }

    public int calcuateNumber(List<Integer> winningNumbers, int bonusNumber) {
        int matchNumber = this.countMatchingNumbers(winningNumbers);
        if (matchNumber == 6) {
            return 7;
        } else {
            return matchNumber + this.checkBonusNumber(bonusNumber);
        }
    }
}
