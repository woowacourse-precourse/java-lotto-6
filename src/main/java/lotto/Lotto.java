package lotto;

import java.util.List;

import static lotto.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.constant.LottoErrorMessage.LOTTO_LENGTH_ERROR_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR_MESSAGE);
        }
    }
}
