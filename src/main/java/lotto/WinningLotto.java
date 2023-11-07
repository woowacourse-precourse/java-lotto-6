package lotto;

import lotto.validator.InputValidator;
import java.util.List;
import static lotto.utility.StringUtil.*;

public class WinningLotto {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (!InputValidator.isValidNumberCount(numbers))
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_INVALID_COUNT.getMessage());

        if (InputValidator.hasDuplicates(numbers))
            throw new IllegalArgumentException(PRINT_ERR_WINNING_NUMBER_DUPLICATE.getMessage());

        if (!InputValidator.isValidNumberRange(numbers))
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_INVALID_RANGE.getMessage());

        if (!InputValidator.isValidNumberRange(bonusNumber))
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_INVALID_RANGE.getMessage());

        if (InputValidator.hasDuplicatesInWinningNumber(numbers, bonusNumber))
            throw new IllegalArgumentException(PRINT_ERR_WINNING_NUMBER_DUPLICATE.getMessage());
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
