package lotto.exception;

import lotto.domain.WinningNumbers;

public enum ErrorMessage {

    ERROR("[ERROR]"),
    RUN_MESSAGE("에러가 발생했습니다."),
    IS_NOT_MULTIPLE_OF_THOUSAND("금액은 1000원 단위로 입력해주세요."),
    EMPTY("값이 입력되지 않았습니다."),
    IS_NOT_NUMBER("숫자만 입력해주세요."),
    INVALID_DELIMITER(",(콤마)만 입력해주세요."),
    DUPLICATE_NUMBERS("중복된 숫자가 입력되었습니다."),
    DUPLICATE_BONUS_NUMBER("당첨번호와 중복된 숫자입니다."),
    IS_NOT_SIX_NUMBERS("숫자 6개를 입력해주세요."),
    IS_NOT_ONE_NUMBER("숫자 6개를 입력해주세요."),
    INVALID_RANGE("1부터 45까지의 숫자만 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR.message +" "+ message;
    }

}
