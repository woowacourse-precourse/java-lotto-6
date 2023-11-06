package lotto;

import java.util.List;
import static lotto.validator.BonusNumberValidator.validate;
import static lotto.validator.WinningNumbersValidator.validate;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        validate(bonusNumber, numbers);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
}
