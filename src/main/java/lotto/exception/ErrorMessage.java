package lotto.exception;

import static lotto.config.GameNumberConfig.LOTTO_NUMBER_COUNT;

public enum ErrorMessage {
    VALIDATE_INPUT_EMPTY("[ERROR] 입력값은 비어있으면 안됩니다."),
    VALIDATE_INPUT_NUMBER("[ERROR] 입력값은 숫자만 가능합니다."),
    VALIDATE_PURCHASE_PRICE_DIVIDE("[ERROR] 입력한 값이 로또 금액으로 나누어 떨어지지 않습니다."),
    
//    Lotto validate 에러 메시지
    VALIDATE_LOTTO_SIZE("[ERROR] 로또 번호는 %d개 입니다.".formatted(LOTTO_NUMBER_COUNT.getNumber())),
    VALIDATE_LOTTO_SORT("[ERROR] 로또 번호는 오름차순으로 정렬되어야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}
