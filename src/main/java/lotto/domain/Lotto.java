package lotto.domain;

import static lotto.constants.Error.DUPLICATE_INVALID;
import static lotto.constants.Error.SIZE_INVALID;
import static lotto.constants.Rule.LOTTO_SIZE;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(SIZE_INVALID.getMessage());
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_INVALID.getMessage());
        }
    }

    public int countMatchNumbers(Prize prize) {
        return (int) numbers.stream().filter(prize.getLotto()::isMatchNumber).count();
    }

    public boolean isMatchNumber(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
