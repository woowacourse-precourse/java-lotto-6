package lotto.domain.model.lotto;

import lotto.error.ErrorMessage;
import lotto.config.LottoConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

    private static final Map<Integer, LottoNumber> numbers = new HashMap<>();
    private final Integer number;

    private LottoNumber(final Integer number) {
        this.number = number;
    }

    public static LottoNumber from(final Integer number) {
        validate(number);
        return numbers.computeIfAbsent(number, LottoNumber::new);
    }

    public Integer getNumber() {
        return number;
    }

    private static void validate(final Integer number) {
        if (isNotInRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private static boolean isNotInRange(final Integer number) {
        return number < LottoConfig.LOTTO_NUMBER_MIN.getValue() || number > LottoConfig.LOTTO_NUMBER_MAX.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber that)) return false;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
