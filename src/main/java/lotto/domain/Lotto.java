package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.List;
import java.util.Objects;

public class Lotto {

    public static final int PRICE = 1_000;
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateLottoNumbersCount(numbers);
        LottoValidator.validateUniqueLottoNumbers(numbers);
        LottoValidator.validateLottoNumbersRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Lotto lotto = (Lotto) object;

        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }
}
