package lotto;


import lotto.validator.LottoValidator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.NumericConstant.LOTTO_NUMBER_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateIsProperSize(numbers);
        LottoValidator.validateDuplicatedNumber(numbers);

        for (int number : numbers) {
            LottoValidator.validateRangeOfNumber(number);
        }
    }
    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }
    @Override
    public String toString() {
        String joinedNumbers = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return String.format("[%s]", joinedNumbers);
    }
}
