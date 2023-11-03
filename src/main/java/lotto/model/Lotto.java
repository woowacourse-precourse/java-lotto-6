package lotto.model;

import static lotto.model.LottoConstant.LOTTO_NUMBERS_SIZE;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public boolean isContainsNumber(final int number) {
        return numbers.contains(number);
    }

    public boolean isContainsNumbersWithSize(final List<Integer> numbers, final int size) {
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        lottoNumbers.retainAll(numbers);

        return lottoNumbers.size() == size;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
