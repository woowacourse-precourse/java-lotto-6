package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator lottoValidator = new LottoValidator();

        lottoValidator.checkSize(numbers);
        lottoValidator.checkRange(numbers);
        lottoValidator.checkDuplicateWinningNumbers(numbers);
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    public int matchSameNumberCount(Lotto lotto) {
        int sameNumberCount = (int) numbers.stream()
                .filter(number -> lotto.hasSameNumber(number))
                .count();

        return sameNumberCount;
    }

    public boolean hasSameNumber(int number) {
        return numbers.contains(number);
    }
}
