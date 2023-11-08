package lotto.domain;

import lotto.validation.LottoNumberValidator;
import lotto.view.ErrorMessage;

import java.util.HashSet;
import java.util.List;

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

        LottoNumberValidator validator = new LottoNumberValidator();
        validator.run(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

}
