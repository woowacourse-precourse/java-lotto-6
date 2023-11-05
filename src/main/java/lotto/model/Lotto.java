package lotto.model;

import java.util.List;
import lotto.util.ValidationCheck;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidationCheck validationCheck = new ValidationCheck();
        // 1. 숫자 개수 검증
        validationCheck.checkNumLength(numbers);

        // 2. 숫자 중복 여부 검증
        validationCheck.checkDuplicatedNum(numbers);
    }

    public boolean existNumber(int givenNumber) {
        return this.numbers.contains(givenNumber);
    }
}
