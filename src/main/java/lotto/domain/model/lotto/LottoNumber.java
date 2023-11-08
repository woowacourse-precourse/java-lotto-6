package lotto.domain.model.lotto;

import lotto.constants.LottoConfig;

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
            throw new IllegalArgumentException("[ERROR] 로또 번호 범위가 아닙니다.");
        }
    }

    private static boolean isNotInRange(final Integer number) {
        return number < LottoConfig.LOTTO_NUMBER_MIN || number > LottoConfig.LOTTO_NUMBER_MAX;
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
