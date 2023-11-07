package lotto.domain;

import static lotto.global.ErrorMessage.INVALID_LOTTO_SIZE_ERROR;
import static lotto.global.ErrorMessage.NUMBER_DUPLICATED_ERROR;
import static lotto.global.LottoInformation.LOTTO_BALLS_NUMBER;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateLottoSize(final List<Integer> numbers) {
        if (isDifferentSize(numbers, LOTTO_BALLS_NUMBER)) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private void validateDuplicate(final List<Integer> lotto) {
        final int lottoSizeWithoutDuplicate = (int) lotto.stream()
                .distinct()
                .count();

        if (isDifferentSize(lotto, lottoSizeWithoutDuplicate)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATED_ERROR.getMessage());
        }
    }

    private static boolean isDifferentSize(final List<Integer> lotto, final int lottoSizeWithoutDuplicate) {
        return lotto.size() != lottoSizeWithoutDuplicate;
    }

    public List<Integer> getLotto() {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public boolean containsNumber(final int number) {
        return numbers.contains(number);
    }

    public int matchNumber(final Lotto lottoToCompare) {
        return (int) this.numbers.stream()
                .filter(lottoToCompare::containsNumber)
                .count();
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
}
