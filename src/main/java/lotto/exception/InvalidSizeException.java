package lotto.exception;

import lotto.config.LottoGameRule;

public class InvalidSizeException extends LottoGameException {

    private static final String MESSAGE =
            String.format("로또 번호 개수는 %d개야 합니다.", LottoGameRule.LOTTO_SIZE.value());

    public InvalidSizeException() {
        super(MESSAGE);
    }
}
