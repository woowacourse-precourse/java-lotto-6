package lotto.exception.lotto;

import lotto.exception.CustomException;

public class LottoNumberDuplicateException extends CustomException {

    private static final String message = "[ERROR] : 중복된 숫자가 로또 번호에 있으면 안됩니다.";

    public LottoNumberDuplicateException() {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
