package lotto.domain;

import static lotto.enums.ErrorMassage.DUPLICATE_LOTTO_NUMBER;
import static lotto.enums.ErrorMassage.INVALID_LOTTO_COUNT;
import static lotto.enums.LottoConfig.LOTTO_COUNT;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(final List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validateSize(final List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT.getMassage());
        }
    }

    private void validateDuplicatedNumber(final List<LottoNumber> numbers) {
        final int distinctCount = (int) numbers.stream()
                .distinct()
                .count();
        if (distinctCount != LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMassage());
        }
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
