package lotto.domain;

import static lotto.constant.ExceptionMessage.*;

import java.util.List;

public class WinnerNumbers extends Lotto {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinnerNumbers(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(numbers);

        validateNumberRange(bonusNumber);
        validateBonusNumberInNumbers(numbers, bonusNumber);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateBonusNumberInNumbers(numbers, bonusNumber);
    }

    private static void validateBonusNumberInNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_IN_WINNER_NUMBERS);
        }
    }
}
