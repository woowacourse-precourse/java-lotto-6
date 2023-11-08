package lotto.model;

import java.util.List;
import lotto.util.ErrorMessage;
import lotto.util.validate.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_LOTTO_NUMBERS.getMessage());
        }
        LottoValidator.validateLotto(numbers);
    }

    // TODO: 추가 기능 구현
}
