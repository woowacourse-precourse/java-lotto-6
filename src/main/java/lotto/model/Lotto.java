package lotto.model;

import lotto.enums.ErrorMsg;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_LOTTO_NUMBER_COUNT.getErrMsg());
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_LOTTO_NUMBER_DUPLICATE.getErrMsg());
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_LOTTO_NUMBER_RANGE.getErrMsg());
        }
    }


}
