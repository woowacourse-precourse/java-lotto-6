package lotto.domain;

import java.util.List;
import lotto.constants.ErrorMessages;
import lotto.constants.LottoValues;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Integer lottoNumbersCount = LottoValues.NUMBERS_COUNT.getValue();
        if (numbers.size() != lottoNumbersCount) {
            throw new IllegalArgumentException(
                    ErrorMessages.LOTTO_NUMBERS_COUNT.getMessage(List.of(lottoNumbersCount))
            );
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
