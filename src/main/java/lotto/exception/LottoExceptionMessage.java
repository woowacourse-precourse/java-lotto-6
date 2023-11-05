package lotto.exception;

import lotto.domain.constant.LottoConstant;

public enum LottoExceptionMessage implements LottoConstant {
    INVALID_PICK_COUNT(String.format("%d개의 숫자를 입력해주세요!",PICK_COUNT)),
    INVALID_NUMBER(String.format("%d 과 %d 사이 숫자를 입력해주세요!",MIN_NUMBER,MAX_NUMBER));

    private final String message;
    LottoExceptionMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}

