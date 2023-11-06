package lotto.exception;

import static java.lang.String.format;
import static lotto.view.NumberConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.view.NumberConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.view.NumberConstant.VALIDATE_LOTTO_SIZE;

public enum ExceptionMessage {
    
    EMPTY_INPUT_ERROR("비어 있는 값입니다. 다시 입력해 주세요."),
    INVALID_NUMBER_ERROR("숫자가 아닙니다. 다시 입력해 주세요."),
    MINIMUM_PAYMENT_ERROR("로또 구입 비용 이상으로 입력해 주세요."),
    HAS_BOTH_ENDS_SEPARATOR("입력값 시작 또는 끝에 구분자가 포함되어 있습니다. 다시 입력해 주세요."),
    PURCHASE_AMOUNT_ERROR("1000원 단위의 금액을 입력해 주세요."),
    WINNING_NUMBERS_SIZE_ERROR(format("%d개의 숫자를 입력해 주세요.", VALIDATE_LOTTO_SIZE)),
    LOTTO_NUMBER_OUT_OF_RANGE(
            format("%d~%d 사이의 숫자를 입력해 주세요.", MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)),
    WINNING_NUMBERS_AND_BONUS_NUMBER("로또 번호와 보너스 번호 사이에 중복이 있습니다. 다시 입력해 주세요."),
    WINNING_NUMBERS_ERROR("1~45 사이의 숫자 6개를 공백 없이 %s로 구분하여 입력해 주세요."),
    BONUS_NUMBER_ERROR("1~45 사이의 숫자를 입력해 주세요."),
    DUPLICATE_NUMBER_ERROR("중복된 숫자가 있습니다."),
    SYSTEM_ERROR("시스템에 문제가 발생했습니다.");
    
    private static final String EXCEPTION_PREFIX = "[ERROR]";
    private final String message;
    
    ExceptionMessage(final String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return format("%s %s", EXCEPTION_PREFIX, message);
    }
}
