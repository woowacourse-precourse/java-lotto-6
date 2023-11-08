package lotto.model;

import java.util.List;
import lotto.utils.enums.Code;
import lotto.utils.InputValidator;

public class WinningNumbers {

    private final Lotto winningNumbers;

    public WinningNumbers(List<Integer> numbers) {
        this.winningNumbers = new Lotto(numbers);
        numbers.forEach(
                number -> InputValidator.validateNumberInRange(number, Code.WINNING.getCode()));
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

}
