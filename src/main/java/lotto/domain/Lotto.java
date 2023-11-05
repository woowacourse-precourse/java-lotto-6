package lotto.domain;

import static lotto.ErrorMassage.*;
import static lotto.domain.LottoConfig.LOTTO_COUNT;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_COUNT.getMassage());
        }
    }

    private void validateDuplicatedNumber(List<LottoNumber> numbers) {
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();
        if (distinctCount != LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(IS_DUPLICATED_LOTTO_NUMBER.getMassage());
        }
    }
}
