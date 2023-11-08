package lotto.domain.lotto;

import lotto.utils.ErrorMessage;
import lotto.utils.LottoUtils;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
        numbers.forEach(LottoUtils::validateNumber);
        validateDuplicatedNumber(numbers);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public void checkDuplicatedNumber(int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }


    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }


    public int matchingLotto(Lotto lotto) {
        return (int) lotto.numbers.stream()
                .filter(this::isMatchedNumber)
                .count();
    }

    public boolean isMatchedNumber(int number) {
        return numbers.contains(number);
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

    /**
     * 로또 번호를 출력한다.
     * ex) [1, 2, 3, 4, 5, 6]
     */
    @Override
    public String toString() {
        return numbers.toString();
    }
}
