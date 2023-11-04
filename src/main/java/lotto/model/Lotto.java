package lotto.model;

import java.util.ArrayList;
import java.util.List;
import static lotto.config.LottoConfig.LOTTO_VALUE_MIN;
import static lotto.config.LottoConfig.LOTTO_VALUE_MAX;
import static lotto.config.LottoConfig.LOTTO_VALUE_SIZE;
import static lotto.Message.ErrorMessage.LOTTO_RANGE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.LOTTO_SIZE_ERROR_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        rangeValidate(numbers);
        sizeValidate(numbers);
        this.numbers = numbers;
    }

    private void rangeValidate(List<Integer> numbers) {
        for (Integer number: numbers) {
            if (number < LOTTO_VALUE_MIN.getValue() || number > LOTTO_VALUE_MAX.getValue()) {
                throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
            }
        }
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_VALUE_SIZE.getValue()) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
