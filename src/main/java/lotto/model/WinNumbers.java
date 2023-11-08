package lotto.model;

import java.util.List;
import lotto.validator.LottoValidator;

public class WinNumbers {
    private final List<Integer> winNumbers;

    private WinNumbers(List<Integer> numbers) {
        this.winNumbers = numbers;
    }

    public static WinNumbers createWinNumbers(List<Integer> numbers) {
        if (isValid(numbers)) {
            return new WinNumbers(numbers);
        }
        return null;
    }

    private static boolean isValid(List<Integer> numbers) {
        return LottoValidator.isOverSize(numbers)
                && LottoValidator.isDuplicateNumber(numbers)
                && LottoValidator.isNumbersInRange(numbers);
    }

    public List<Integer> getNumbers() {
        return winNumbers;
    }
}
