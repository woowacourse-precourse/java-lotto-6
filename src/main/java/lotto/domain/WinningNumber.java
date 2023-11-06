package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Util;

public class WinningNumber extends Validation {
    private final List<Integer> winningNumber;

    public WinningNumber(List<String> numbers) {
        this.winningNumber = validateWinningNumber(numbers);
    }

    private List<Integer> validateWinningNumber(List<String> numbers) {
        for (String number : numbers) {
            checkValidInteger(number);
            checkNumberRange(number);
        }

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
