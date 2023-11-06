package lotto;

import java.util.List;

import static lotto.constant.LottoErrorMessage.LOTTO_LENGTH_ERROR_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR_MESSAGE);
        }
    }
}
