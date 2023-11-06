package lotto;

import java.util.List;
import lotto.enums.LottoNumberRange;
import lotto.util.Exception;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumberRange.MIN_SELECT_COUNT.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void checkNumber(List<Integer> numbers) {
        Exception.checkDuplicationNumber(numbers);
        for (int number : numbers) {
            Exception.checkRangeLottoNumber(number);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
