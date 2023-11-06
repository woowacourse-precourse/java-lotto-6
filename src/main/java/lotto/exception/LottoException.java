package lotto.exception;

import lotto.config.GameConfig;

public enum LottoException implements CustomException {

    INVALID_SIZE(String.format("로또 번호는 %d개를 입력해야 합니다.", GameConfig.LOTTO_SIZE)),
    DUPLICATED_NUMBER("로또 번호는 중복되면 안됩니다.");

    private final String message;

    LottoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
