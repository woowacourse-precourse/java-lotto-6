package lotto.domain;

import static lotto.domain.LottoConfig.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoConfig.LOTTO_MIN_NUMBER;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER.getValue() || number > LOTTO_MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(
                    String.format("로또 번호는 %d ~ %d 사이의 숫자여야 합니다.",
                            LOTTO_MIN_NUMBER.getValue(), LOTTO_MAX_NUMBER.getValue())
            );
        }
    }
}
