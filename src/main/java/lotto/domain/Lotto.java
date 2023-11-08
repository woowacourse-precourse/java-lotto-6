package lotto.domain;

import java.util.List;
import lotto.validator.InputValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkWinningNumberRange(numbers);
        inputValidator.checkDuplicateWinningNumber(numbers);
    }

    public List<Integer> getLottosNumber() {
        return this.numbers;

    }

    // TODO: 추가 기능 구현


}
