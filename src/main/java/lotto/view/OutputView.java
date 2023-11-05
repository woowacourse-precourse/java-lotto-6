package lotto.view;

import lotto.message.Message;

import static lotto.message.ErrorMessage.ERROR_PREFIX;

public class OutputView {

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(IllegalArgumentException e) {
        String errorFormatMessage = ErrorMessageFormat(e.getMessage());
        printMessage(errorFormatMessage);
    }
    public String ErrorMessageFormat(String errorMessage) {
        return String.format(ERROR_PREFIX.getMessage(), errorMessage);
    }

    public void printLottoCount(Message message, int purchaseCost) {
        System.out.printf(message.getMessage(), purchaseCost);
    }


}
