package lotto.model;

import java.util.List;
import lotto.utils.enums.Code;
import lotto.utils.InputValidator;

public class WinningNumbers extends Lotto {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        super(numbers);

        numbers.forEach(
                number -> InputValidator.validateNumberInRange(number, Code.WINNING.getCode()));
        this.numbers = numbers;
    }
}
