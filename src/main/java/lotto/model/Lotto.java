package lotto.model;

import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_SIZE_ERROR
                    .getFormattedMessage(LottoConfig.LOTTO_NUMBER_COUNT.getValue()));
        }
        Validator.validateNumbersInRange(numbers);
        Validator.validateUniqueNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
