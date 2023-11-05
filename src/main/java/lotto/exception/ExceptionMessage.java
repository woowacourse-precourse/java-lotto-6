package lotto.exception;

import static lotto.constant.NumberConstant.COUNT;
import static lotto.constant.NumberConstant.END_NUMBER;
import static lotto.constant.NumberConstant.LOTTO_PRICE;
import static lotto.constant.NumberConstant.START_NUMBER;

public enum ExceptionMessage {
    EMPTY("빈 값을 입력할 수 없습니다."),
    NOT_SIX_NUMBER(String.format("로또 번호는 %d개를 입력해야 합니다", COUNT.getValue())),
    NOT_NUMBER("숫자만 입력해야 합니다."),
    INDIVISIBLE(String.format("%,d으로 나누어 떨어지는 금액을 입력해주세요.", LOTTO_PRICE.getValue())),
    DUPLICATED("중복된 값을 입력할 수 없습니다."),
    OUT_OF_RANGE(String.format("%d부터 %d 사이의 숫자를 입력해야 합니다.", START_NUMBER.getValue(), END_NUMBER.getValue())),
    DUPLICATED_BONUS_NUMBER("당첨 번호와 중복된 보너스 번호를 입력할 수 없습니다."),
    OUT_OF_MEMORY("너무 큰 금액을 입력 했습니다.");

    public static final String BASE_MESSAGE = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = BASE_MESSAGE + String.format(message);
    }

    public String getMessage() {
        return message;
    }
}
