package lotto.domain;

import java.util.List;

import lotto.global.Prize;
import lotto.global.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.checkNumberCount(numbers);
        Validator.checkAllInRange(numbers);
        Validator.checkDuplicate(numbers);
    }
}
