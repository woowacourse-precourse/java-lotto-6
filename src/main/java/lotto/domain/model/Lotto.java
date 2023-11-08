package lotto.domain.model;

import static lotto.domain.model.LottoErrorMessages.*;


import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import lotto.domain.LottoConfig;


public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = convertToLottoNumber(numbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.stream()
                .anyMatch(number -> number.equals(lottoNumber));
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(INVALID_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS.getMessage());
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        int uniqueNumbersCount = (int) numbers.stream()
                .distinct()
                .count();
        return uniqueNumbersCount != numbers.size();
    }

    private List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .sorted(Comparator.comparingInt(LottoNumber::getNumber))
                .toList();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) obj;
        return this.numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}