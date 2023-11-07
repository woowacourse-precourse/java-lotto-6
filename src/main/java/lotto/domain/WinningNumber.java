package lotto.domain;

import java.util.List;
import lotto.util.Util;
import lotto.util.validator.LottoValidator;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        String convert = Util.convertIntegerListToString(numbers);
        new LottoValidator().validate(convert);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
