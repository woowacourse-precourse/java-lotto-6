package lotto.exception.bonusnumber;

import lotto.exception.CustomException;

public class BonusNumberRangeException extends CustomException {

    private static final String message = "[ERROR] : 보너스 번호는 1~45 사이 입니다.";

    public BonusNumberRangeException() {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
