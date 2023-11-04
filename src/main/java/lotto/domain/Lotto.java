package lotto.domain;

import static lotto.domain.LottoRule.LOTTO_LENGTH;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        validateLength(numbers);
        validateUnique(numbers);
    }

    private void validateLength(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnique(List<LottoNumber> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicates(List<LottoNumber> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }
}
