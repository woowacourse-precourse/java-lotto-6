package lotto.exception;

import static lotto.constants.LottoConstants.LENGTH;

public class WrongMoneyInputFormatException extends IllegalArgumentException {


    public static final String ERROR_MESSAGE = "[ERROR] 금액은 1000원으로 나누어떨어지는 자연수여야 합니다.";

    public WrongMoneyInputFormatException() {

        super(ERROR_MESSAGE);
    }
}
