package lotto.exception.bonusnumber;

import lotto.exception.CustomException;

public class SameBonusNumberException extends CustomException {

    private static final String message = "[ERROR] : 정답 번호와 동일한 보너스 번호가 있으면 안됩니다.";

    public SameBonusNumberException() {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
