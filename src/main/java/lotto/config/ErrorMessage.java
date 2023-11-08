package lotto.config;

import static lotto.config.LottoConfig.LOTTO_AMOUNT;
import static lotto.config.LottoConfig.LOTTO_SIZE;
import static lotto.config.LottoConfig.MAX_INPUT_LENGTH;
import static lotto.config.LottoConfig.MAX_LOTTO_COUNT;

/**
 * 에러 메시지 관리를 위한 enum 클래스
 */
public enum ErrorMessage {
    TOO_LONG_INPUT_ERROR_MESSAGE(String.format("입력값은 %d자리 이하로 해주세요.", MAX_INPUT_LENGTH.getValue())),
    INPUT_AMOUNT_CHARACTER_ERROR_MESSAGE("구입 금액에는 숫자만 있어야 합니다."),
    INPUT_AMOUNT_DIVISION_ERROR_MESSAGE(String.format("구입 금액은 %d으로 나누어 떨어져야 합니다.", LOTTO_AMOUNT.getValue())),
    INPUT_AMOUNT_TOO_LARGE_ERROR_MESSAGE(String.format("한번에 %d장 이상을 구매할 수 없습니다.", MAX_LOTTO_COUNT.getValue())),

    INPUT_WINNING_NUMBER_SIZE_ERROR_MESSAGE(String.format("정답 번호는 %d개여야 합니다.", LOTTO_SIZE.getValue())),
    INPUT_WINNING_CHARACTER_ERROR_MESSAGE("정답 번호에는 숫자만 있어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
