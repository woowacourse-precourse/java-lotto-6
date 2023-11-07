package lotto.exception;

import static lotto.config.GameNumberConfig.LOTTO_NUMBER_COUNT;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MAX;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MIN;

public enum ErrorMessage {
    VALIDATE_INPUT_EMPTY("[ERROR] 입력값은 비어있으면 안됩니다."),
    VALIDATE_INPUT_NUMBER("[ERROR] 입력값은 숫자만 가능합니다."),
    VALIDATE_PURCHASE_AMOUNT_DIVIDE("[ERROR] 입력값이 로또 금액으로 나누어 떨어지지 않습니다."),
    VALIDATE_LOTTO_SIZE("[ERROR] 로또 번호는 %d개 입력해야 합니다.".formatted(LOTTO_NUMBER_COUNT.getValue())),
    VALIDATE_DUPLICATE("[ERROR] 로또 번호는 중복된 수가 없어야 합니다."),
    VALIDATE_RANGE("[ERROR] 로또 번호는 %d ~ %d 범위 내의 숫자만 가능합니다."
            .formatted(LOTTO_RANGE_MIN.getValue(), LOTTO_RANGE_MAX.getValue())
    ),
    VALIDATE_INPUT_LOTTO_LENGTH("[ERROR] 로또 번호 입력 양식에 맞지 않습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}
