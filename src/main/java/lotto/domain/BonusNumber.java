package lotto.domain;

import lotto.config.ErrorMessage;
import lotto.util.validator.BonusNumberValidator;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    BonusNumber(List<Integer> winningNumbers, String number) {
        new BonusNumberValidator(number);
        this.bonusNumber = Integer.parseInt(number);
        validateExistNumber(winningNumbers, this.bonusNumber);
    }

    private void validateExistNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_NUMBER.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
