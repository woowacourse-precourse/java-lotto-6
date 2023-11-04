package lotto.model.domain;

import java.util.List;
import lotto.constance.PrintConst;

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
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        return String.format(PrintConst.FORMAT_LOTTO_NUMBERS, this.numbers.toArray());
    }
}
