package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.ExceptionMessage;

public record DrawResult(Lotto lotto, Integer bonusNumber) {

    public DrawResult {
        validateRange(bonusNumber);
    }

    public void validateDuplication() {
        List<Integer> validateNumbers = new ArrayList<>(lotto.getNumbers());
        validateNumbers.add(bonusNumber);
        lotto.validateDuplication(validateNumbers);
    }

    public void validateRange(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_SIZE.getMessage());
        }
    }
}
