package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.SortedRandomNumberGenerator;

public class WinningLotto {
    public static final String INVALID_RANGE_MESSAGE = String.format("로또 번호의 숫자 범위는 %d~%d까지입니다.", SortedRandomNumberGenerator.START_RANGE, SortedRandomNumberGenerator.END_RANGE);
    public static final String DUPLICATE_NUMBER_MESSAGE = "숫자가 중복되지 않아야 합니다.";
    private final Lotto winningNumber;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumber) {
        validateWinningNumber(winningNumber);
        this.winningNumber = new Lotto(winningNumber);
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static void validateWinningNumber(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            validateNumberRange(number);
        }
        validateDuplicate(winningNumber);
    }

    public void validateBonusNumber(int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicate(bonusNumber);
    }

    private static void validateNumberRange(int number) {
        if (number < SortedRandomNumberGenerator.START_RANGE || number > SortedRandomNumberGenerator.END_RANGE) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    private void validateDuplicate(int number) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }
}
