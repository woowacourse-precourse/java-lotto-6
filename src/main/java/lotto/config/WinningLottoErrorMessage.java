package lotto.config;

import static lotto.config.LottoConfig.LOTTO_NUMBER_MAX;
import static lotto.config.LottoConfig.LOTTO_NUMBER_MIN;

public enum WinningLottoErrorMessage {
    WINNING_LOTTO_NUMERIC_ERROR_MESSAGE(
            String.format("[ERROR] %s부터 %s까지의 자연수와 콤마만 입력할 수 있습니다.",
                    LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)),
    WINNING_LOTTO_COMMA_ERROR_MESSAEGE(
            "[ERROR] 첫 번째 또는 마지막 문자의 콤마 또는 연속된 콤마는 입력할 수 없습니다."),
    WINNING_LOTTO_UNIQUE_ERROR_MESSAGE("[ERROR] 중복된 번호는 입력할 수 없습니다.");

    private final String message;


    WinningLottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
