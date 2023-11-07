package lotto.domain;

import java.util.List;
import lotto.util.Util;

public class WinningNumber extends Validation {
    private final List<Integer> winningNumber;

    public WinningNumber(List<String> numbers) {
        this.winningNumber = validateWinningNumber(numbers);
    }

    private List<Integer> validateWinningNumber(List<String> numbers) {
        numbers.forEach(this::checkValidInteger);
        numbers.forEach(this::checkNumberRange);

        List<Integer> numbersInteger = Util.convertToIntegerList(numbers);
        checkNumbersLength(numbersInteger);
        checkNumbersDuplicate(numbersInteger);

        return numbersInteger;
    }

    public Lotto createWinningLotto() {
        return new Lotto(winningNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
