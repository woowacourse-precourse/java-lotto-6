package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printLottoNumbers() {
        System.out.println(numbers);
    }

    public Rank compareWithWinningNumbers(List<Integer> winningLotto) {
        List<Integer> winningNumbers = new ArrayList<>(winningLotto);
        int winningBonusNumber = winningNumbers.get(6);
        winningNumbers.remove(6);

        int correctCount = getCorrectCount(winningNumbers);
        int bonusCount = getBonusCount(winningBonusNumber);
        return getRankFromCount(correctCount, bonusCount);
    }

    private int getCorrectCount(List<Integer> winningNumbers) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    private int getBonusCount(int winningBonusNumber) {
        if (numbers.contains(winningBonusNumber))
            return 1;
        return 0;
    }

    private Rank getRankFromCount(int correctCount, int bonusCount) {
        if (correctCount == 6)
            return Rank.FIRST;

        if (correctCount == 5 && bonusCount == 1)
            return Rank.SECOND;

        if (correctCount == 5)
            return Rank.THIRD;

        if (correctCount == 4)
            return Rank.FOURTH;

        if (correctCount == 3)
            return Rank.FIFTH;

        return Rank.NONE;
    }
}
