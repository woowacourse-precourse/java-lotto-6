package lotto.exception.lotto;

import lotto.exception.CustomException;

public class LottoNumberSizeException extends CustomException {

    private static final String message = "[ERROR] : 로또 번호는 6개 입니다.";

    public LottoNumberSizeException() {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
