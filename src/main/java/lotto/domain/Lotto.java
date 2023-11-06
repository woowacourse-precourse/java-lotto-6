package lotto.domain;

import static lotto.global.LottoInformation.LOTTO_BALLS_NUMBER;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateLottoSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_BALLS_NUMBER.getValue()) {
            throw new IllegalArgumentException(LOTTO_BALLS_NUMBER.getValue() + "개의 로또 번호가 필요합니다.");
        }
    }

    private void validateDuplicate(final List<Integer> lotto) {
        final int lottoSizeWithoutDuplicate = (int) lotto.stream().distinct().count();

        if (lotto.size() != lottoSizeWithoutDuplicate) {
            throw new IllegalArgumentException("로또 번호가 중복됩니다");
        }
    }

    public List<Integer> getLotto() {
        return numbers.stream().sorted().toList();
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int matchNumber(Lotto lottoToCompare) {
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
