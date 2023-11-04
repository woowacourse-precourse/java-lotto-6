package lotto.domain;

import static lotto.ErrorMessage.LOTTO_LENGTH_ERROR;

import java.util.List;
import java.util.Set;

public final class Lotto {
    private static final int LOTTO_LENGTH = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::valueOf)
                .toList();

        validate(lottoNumbers);
        this.numbers = Set.copyOf(lottoNumbers);
    }

    private void validate(List<LottoNumber> numbers) {
        validateLength(numbers);
    }

    private void validateLength(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(String.format(LOTTO_LENGTH_ERROR.getMessage(), LOTTO_LENGTH));
        }
    }
}
