package lotto.domain;

import lotto.domain.constants.LottoRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> validNumbers = new ArrayList<>(numbers);
        Collections.sort(validNumbers);
        this.numbers = validNumbers;
    }

    private void validate(List<Integer> numbers) {
        lottoSizeValidate(numbers);
        lottoNumberRangeValidate(numbers);
        lottoDuplicateNumberValidate(numbers);
    }

    private void lottoSizeValidate(List<Integer> numbers) {
        if (numbers.size() != LottoRule.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void lottoNumberRangeValidate(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < LottoRule.LOTTO_MIN_NUMBER.getValue()
                    || number > LottoRule.LOTTO_MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException();
            }
        });
    }

    private void lottoDuplicateNumberValidate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoRule.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }
}
