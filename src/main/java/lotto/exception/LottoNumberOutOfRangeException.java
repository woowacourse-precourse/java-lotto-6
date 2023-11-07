package lotto.exception;

import lotto.config.LottoGameRule;

public class LottoNumberOutOfRangeException extends LottoGameException {
    private static final String MESSAGE = String.format("로또 번호는 %d~%d 사이어야 합니다.",
            LottoGameRule.LOTTO_MIN_VALUE.value(), LottoGameRule.LOTTO_MAX_VALUE.value());

    public LottoNumberOutOfRangeException() {
        super(MESSAGE);
    }
}
