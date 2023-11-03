package lotto.domain;

import static lotto.valid.WinNumberValid.validLottoNums;

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
        validLottoNums(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
