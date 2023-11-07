package lotto.domain;

import java.util.List;

public class Lotto {
    private final LottoNumber numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new LottoNumber(numbers);
    }

    public int matchNumbers(LottoNumber target) {
        return numbers.matchNumbers(target);
    }

    public boolean containsBonusNumber(int targetBonusNumber) {
        return numbers.containsBonusNumber(targetBonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
