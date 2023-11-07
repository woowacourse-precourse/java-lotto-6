package lotto.exception.lotto;

import lotto.exception.CustomException;

public class LottoNumberRangeException extends CustomException {

    private static final String message = "[ERROR] : 로또 번호는 1부터 45 사이어야 합니다.";

    public LottoNumberRangeException() {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}

