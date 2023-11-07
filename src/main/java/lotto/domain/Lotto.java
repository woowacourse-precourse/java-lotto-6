package lotto.domain;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumber.LOTTO_COUNT.getNumber()) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATE_BONUS_NUMBER_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
