package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_COUNT = 6;
    private static final int BONUS_INDEX = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException("로또 번호에 중복이 없어야 합니다.");
        }
    }

    public void printLottoNumbers() {
        System.out.println(numbers);
    }

    public Rank compareWithWinningNumbers(List<Integer> winningLotto) {
        int winningBonusNumber = winningLotto.get(BONUS_INDEX);

        int correctCount = getCorrectCount(winningLotto);
        int bonusCount = getBonusCount(winningBonusNumber);
        return getRankFromCount(correctCount, bonusCount);
    }

    private int getCorrectCount(List<Integer> winningNumbers) {
        int count = 0;
        for (int i = 0; i < winningNumbers.size()-1; i++) {
            int winningNumber = winningNumbers.get(i);
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
