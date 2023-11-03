package lotto.domain;

import lotto.resource.LottoValue;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoSizeValidate(numbers);
        lottoNumberRangeValidate(numbers);
        lottoDuplicateNumberValidate(numbers);
    }

    private void lottoSizeValidate(List<Integer> numbers) {
        if (numbers.size() != LottoValue.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void lottoNumberRangeValidate(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < LottoValue.LOTTO_MIN_NUMBER.getValue()
                    || number > LottoValue.LOTTO_MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException();
            }
        });
    }

    private void lottoDuplicateNumberValidate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoValue.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}
