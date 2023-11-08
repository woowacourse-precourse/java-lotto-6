package lotto;

import static lotto.Constant.LOTTO_TICKET_PRICE;
import static lotto.Constant.MAX_NUMBER_SIZE;

public enum ErrorMessage {
    NOT_INT("[ERROR] 정수가 아닌 입력입니다."),
    NOT_POSITIVE("[ERROR] 양수가 아닌 정수값 입력입니다."),
    INVALID_NUMBER_SIZE("[ERROR] 로또 번호가 " + MAX_NUMBER_SIZE + "개가 아닙니다."),
    NUMBER_DUPLICATE("[ERROR] 로또 번호 중 중복이 있습니다."),
    BONUS_DUPLICATE("[ERROR] 보너스 번호와 로또 번호 중 중복이 있습니다."),
    MUST_MOD_RESULT_ZERO("[ERROR] 구입 금액이 " + LOTTO_TICKET_PRICE + "으로 나누어 떨어지지 않습니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
