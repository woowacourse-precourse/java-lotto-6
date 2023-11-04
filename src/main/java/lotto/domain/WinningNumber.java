package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class WinningNumber {

    private static final String NO_DUPLICATE_ERROR_MESSAGE = "중복된 숫자는 입력할 수 없습니다.";
    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        validateDuplicate(winningNumber);
        this.winningNumber = winningNumber;
    }

    private void validateDuplicate(List<Integer> winningNumber) {
        if (isDuplicateNumbers(winningNumber)) {
            throw new IllegalArgumentException(NO_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private boolean isDuplicateNumbers(List<Integer> winningNumber) {
        return new HashSet<>(winningNumber).size() < 6;
    }
}
