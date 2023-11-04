package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class WinningNumber {

    private static final String NO_DUPLICATE_ERROR_MESSAGE = "중복된 숫자는 입력할 수 없습니다.";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "1 ~ 45사이의 숫자만 입력할 수 있습니다.";
    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        validateOutOfRange(winningNumber);
        validateDuplicate(winningNumber);
        this.winningNumber = winningNumber;
    }

    public int calculateCorrectNumberCount(Lotto lotto) {
        int count = 0;
        for (int number : winningNumber) {
            if (lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void validateDuplicate(List<Integer> winningNumber) {
        if (isDuplicateNumbers(winningNumber)) {
            throw new IllegalArgumentException(NO_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateOutOfRange(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private boolean isDuplicateNumbers(List<Integer> winningNumber) {
        return new HashSet<>(winningNumber).size() < 6;
    }

    private boolean isOutOfRange(int number) {
        return 45 < number || number < 1;
    }
}
