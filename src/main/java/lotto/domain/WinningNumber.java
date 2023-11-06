package lotto.domain;

import java.util.List;
import lotto.util.Convertor;
import lotto.validation.LottoNumberValidator;

public class WinningNumber {
    private final List<Integer> numbers;

    private WinningNumber(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        this.numbers = numbers;
    }

    public static WinningNumber from(String input) {
        return new WinningNumber(Convertor.convertStringToIntegerList(input));
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }
}
