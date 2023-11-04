package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.constant.NumberConstant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
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

    public static List<Integer> pickUniqueNumbersInRange() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE);
    }

    public static Lotto createLotto(final List<Integer> numbers) {
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);
        return new Lotto(mutableNumbers);
    }

    public int calculateCorrectAmount(final WinningLotto winningLotto) {
        int correctAmount = MIN_ACCOUNT_AMOUNT;
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
