package lotto.domain;

import java.util.List;
import lotto.exception.ModelExceptionConstant;

public class WinningNumbers {
    List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateWinningNumbersSize(numbers);

        this.numbers = numbers;
    }

    private void validateWinningNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ModelExceptionConstant.OUT_OF_WINNING_NUMBERS_SIZE.getText());
        }
    }

}
