package lotto.domain;

import lotto.constant.ErrorMessage;
import java.util.List;


public class BonusNumberOfUser {
    private final List<Integer> number;

    public BonusNumberOfUser(List<Integer> number) {
        validateRange(number);
        validateSize(number);
        this.number = number;
    }
    private void validateRange(List<Integer> number) {
        if (number.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }
    private void validateSize(List<Integer> number) {
        if (number.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_SIZE.getMessage());
        }
    }
}

