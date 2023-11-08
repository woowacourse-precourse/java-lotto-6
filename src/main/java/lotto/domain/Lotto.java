package lotto.domain;

import lotto.util.LottoUtil;
import lotto.validation.LottoValidation;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = LottoUtil.sortNumbersAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoValidation.validateRange(numbers);
        LottoValidation.validateDuplicates(numbers);
        LottoValidation.validateLength(numbers);
    }

    public int countMatches(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
