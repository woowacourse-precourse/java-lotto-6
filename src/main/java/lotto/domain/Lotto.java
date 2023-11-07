package lotto.domain;

import lotto.domain.dto.output.LottoDto;
import lotto.exception.ExceptionMessage;

import java.util.List;
import java.util.Objects;

import static lotto.exception.ExceptionMessage.LOTTO_NUMBERS_DUPLICATED;


public class Lotto {
    public static final int LOTTO_NUMBERS_LENGTH = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = toSortedLottoNumbers(numbers);
    }

    private static long getDistinctLength(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    private static List<LottoNumber> toSortedLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }

    private static void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw ExceptionMessage.LOTTO_NUMBERS_LENGTH.getException();
        }
    }

    private static void validateDuplicatedNumber(List<Integer> numbers) {
        if (getDistinctLength(numbers) != LOTTO_NUMBERS_LENGTH) {
            throw LOTTO_NUMBERS_DUPLICATED.getException();
        }
    }

    public LottoDto toLottoDto() {
        List<Integer> lottoNumbers = numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
        return new LottoDto(lottoNumbers);
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

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
