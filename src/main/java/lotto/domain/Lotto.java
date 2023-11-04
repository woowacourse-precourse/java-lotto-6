package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.enums.LottoEnum;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoEnum.SELECTED_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.OVER_MAX_SIZE_MESSAGE.getMessage());
        }
        if (numbers.stream().distinct().count() != LottoEnum.SELECTED_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
        if (numbers.stream().anyMatch(number -> number < LottoEnum.MIN_LOTTO_NUMBER.getValue()
                || number > LottoEnum.MAX_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }

    public String toHash() {
        return super.toString();
    }
}
