package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.ArrayList;
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

    public int matchSameNumberNum(Lotto lotto) {
        int sameNumberNum = (int) numbers.stream()
                .filter(number -> lotto.hasSameNumber(number))
                .count();

        return sameNumberNum;
    }

    public boolean hasSameNumber(int number) {
        return numbers.contains(number);
    }
}
