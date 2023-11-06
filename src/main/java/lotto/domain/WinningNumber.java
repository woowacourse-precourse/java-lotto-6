package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

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

        List<Integer> numbersInteger = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

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
