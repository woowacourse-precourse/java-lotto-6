package lotto.config;

import static lotto.config.LottoConfig.LOTTO_NUMBER_MAX;
import static lotto.config.LottoConfig.LOTTO_NUMBER_MIN;

public enum BonusNumberErrorMessage {
    BONUS_NUMBER_ERROR_MESSAGE(
            String.format("[ERROR] %s부터 %s까지의 자연수 하나만 입력할 수 있습니다.",
                    LOTTO_NUMBER_MIN.getValue(), LOTTO_NUMBER_MAX.getValue())),
    BONUS_NUMBER_UNIQUE_ERROR_MESSAGE("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");

    private final String message;

    BonusNumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
