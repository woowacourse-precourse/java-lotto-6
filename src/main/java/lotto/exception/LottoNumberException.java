package lotto.exception;

import lotto.config.GameConfig;

public enum LottoNumberException implements CustomException {

    INVALID_RANGE(String.format("%d에서 %d 사이의 숫자만 입력 가능합니다.", GameConfig.LOTTO_MIN_NUMBER, GameConfig.LOTTO_MAX_NUMBER));

    private final String message;

    LottoNumberException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
