package lotto.view;

import lotto.code.ExceptionMessage;

public class ExceptionOutput {
    private final static String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private final ExceptionMessage errorMessage;
    public ExceptionOutput(ExceptionMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void amountErrorMessage() {
        System.out.println(ERROR_MESSAGE_HEADER + errorMessage.AMOUNT_NUMBER_ERROR.getMessage());
    }

    public void lottoNumberErrorMessage() {
        System.out.println(ERROR_MESSAGE_HEADER + errorMessage.LOTTO_NUMBER_ERROR.getMessage());
    }

    public void bonusNumberErrorMessage() {
        System.out.println(ERROR_MESSAGE_HEADER + errorMessage.BONUS_NUMBER_ERROR.getMessage());
    }
}
