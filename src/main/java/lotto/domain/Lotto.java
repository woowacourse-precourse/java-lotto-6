package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

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
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void lottoNumberRangeValidate(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException();
            }
        });
    }

    private void lottoDuplicateNumberValidate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
