package lotto.domain;

import static lotto.domain.LottoRule.LOTTO_LENGTH;

import java.util.List;
import lotto.view.ErrorMessage;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> mapToSortedIntegers() {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .sorted()
                .toList();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int countMatchingNumber(Lotto target) {
        return (int) numbers.stream()
                .filter(target::contains)
                .count();
    }

    private void validate(List<LottoNumber> numbers) {
        validateLength(numbers);
        validateUnique(numbers);
    }

    private void validateLength(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_LENGTH.getErrorMessage());
        }
    }

    private void validateUnique(List<LottoNumber> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO.getErrorMessage());
        }
    }

    private boolean hasDuplicates(List<LottoNumber> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }
}
