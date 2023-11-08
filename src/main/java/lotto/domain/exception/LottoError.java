package lotto.domain.exception;

import lotto.global.exception.base.LottoGameError;

public enum LottoError implements LottoGameError {

    UNAVAILABLE_NUMBER_RANGE("유효한 범위가 아닙니다. 1부터 45사이의 정수를 입력해주세요."),
    UNAVAILABLE_NUMBER_QUANTITY("숫자가 너무 많거나 적습니다. 6개의 정수만 입력해주세요."),
    DUPLICATED_NUMBER_EXIST("중복되는 숫자가 숫자가 존재합니다. 서로 다른 정수 6개만 입력해주세요."),
    ;

    private final String errorMessage;

    LottoError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

}
