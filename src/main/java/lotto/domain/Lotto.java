package lotto.domain;

import static lotto.ErrorMessage.LOTTO_LENGTH_ERROR;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Lotto {
    private static final int LOTTO_LENGTH = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this(numbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet()));
    }

    private Lotto(Set<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(String.format(LOTTO_LENGTH_ERROR.getMessage(), LOTTO_LENGTH));
        }
    }
}
