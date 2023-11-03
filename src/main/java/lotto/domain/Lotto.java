package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        validateDuplication(numbers);
    }

    private void validateDuplication(final List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static List<Integer> pickUniqueNumbersInRange() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static Lotto createLotto(final List<Integer> numbers) {
        numbersOrderByAsc(numbers);
        return new Lotto(numbers);
    }

    private static void numbersOrderByAsc(final List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public int calculateCorrectAmount(final WinningLotto winningLotto) {
        int correctAmount = 0;
        for (int number : numbers) {
            if (isCorrect(winningLotto, number)) {
                correctAmount++;
            }
        }

        return correctAmount;
    }

    public boolean calculateBonusCorrect(final WinningLotto winningLotto) {
        int bonusNumber = winningLotto.getBonusNumber();
        return numbers.contains(bonusNumber);
    }

    private boolean isCorrect(final WinningLotto winningLotto, final int number) {
        for (int winningNumber : winningLotto.getWinningNumbers()) {
            if (number == winningNumber) {
                return true;
            }
        }
        return false;
    }

    // getter
    public List<Integer> getNumbers() {
        return numbers;
    }
}
