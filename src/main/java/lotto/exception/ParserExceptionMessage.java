package lotto.exception;

import lotto.domain.constant.LottoConstant;
import lotto.domain.constant.ParserConstant;

public enum ParserExceptionMessage implements ParserConstant {
    NOT_NUMBER("숫자를 입력해주세요"),
    NOT_DELIMITER(String.format("%s 로 구분하여 숫자를 입력해주세요!",DELIMITER));
    private final String message;
    ParserExceptionMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}

