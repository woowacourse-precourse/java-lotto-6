package lotto.exception;

import static lotto.util.ConstantMessages.INPUT_PARSER_CHAR;
import static lotto.util.ConstantNumbers.MAXIMUM_Lotto_NUMBER;
import static lotto.util.ConstantNumbers.MINIMUM_Lotto_NUMBER;

public enum ErrorMessage {
    NOT_INTEGER("[ERROR] 숫자가 아닙니다."),
    SIZE_MISS("[ERROR] 로또 번호의 개수가 규정과 다릅니다."),
    NUMBER_MISS("[ERROR] 로또 번호는" + MINIMUM_Lotto_NUMBER.getConstant() +
            "부터 " + MAXIMUM_Lotto_NUMBER.getConstant() + " 사이의 숫자여야 합니다."),
    HAS_SPACE("[ERROR] 공백이 포함되어 있습니다."),
    NUMBER_DUPLICATE("[ERROR] 겹치는 숫자가 있습니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호가 로또 번호와 겹칩니다."),
    COMMA_START_END("[ERROR] " + INPUT_PARSER_CHAR.getMessage()
            + "로 시작하거나 끝나면 안됩니다."),
    HAS_REMAINING_NUMBER("[ERROR] 잔돈이 발생합니다.");

    private final String errorMessage;

    ErrorMessage (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
