package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> number;

    public Lotto(List<Integer> number) {
        validateRange(number);
        validateSize(number);
        validateDuplication(number);
        this.number = number;
    }
    private void validateRange(List<Integer> number) {
        if (number.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
    private void validateSize(List<Integer> number) {
        if (number.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_SIZE.getMessage());
        }
    }
    private void validateDuplication(List<Integer> number) {
        Set<Integer> numbers = new HashSet<>(number);
        if (numbers.size() != number.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_LOTTO_NUMBER.getMessage());
        }
    }
}
