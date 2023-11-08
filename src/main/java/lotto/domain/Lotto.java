package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.List;
import java.util.Objects;


public class Lotto {
    public static final int LOTTO_NUMBERS_LENGTH = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateNumbersLength(numbers);
        LottoValidator.validateDuplicatedNumber(numbers);
        this.numbers = toSortedLottoNumbers(numbers);
    }

    private static List<LottoNumber> toSortedLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
