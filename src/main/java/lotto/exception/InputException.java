package lotto.exception;

import lotto.config.GameConfig;

public enum InputException implements CustomException {

    INVALID_INTEGER("숫자만 입력 가능합니다."),
    INVALID_DELIMITER(String.format("숫자는 %s로 구분해야 합니다.", GameConfig.LOTTO_NUMBER_INPUT_DELIMITER)),
    INVALID_INPUT("입력 값이 비어있습니다.");

    private final String message;

    InputException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
