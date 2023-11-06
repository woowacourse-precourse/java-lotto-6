package lotto.domain;

import static lotto.enums.ErrorMassage.DUPLICATE_LOTTO_NUMBER;
import static lotto.enums.ErrorMassage.INVALID_LOTTO_COUNT;
import static lotto.enums.LottoConfig.LOTTO_COUNT;

import java.util.Collections;
import java.util.List;

public record Lotto(List<LottoNumber> numbers) {
    public Lotto {
        validateSize(numbers);
        validateDuplicatedNumber(numbers);
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

    public List<LottoNumber> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int getMatchCount(final Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }
}
