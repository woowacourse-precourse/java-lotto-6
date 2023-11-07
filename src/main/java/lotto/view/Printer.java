package lotto.view;

import static lotto.message.ErrorMessage.ERROR_MESSAGE_HEAD;
import static lotto.message.InfoMessage.*;
import static lotto.message.ErrorMessage.INVALID_MONEY_INPUT_EXCEPTION;

public class Printer {
    public static void printPurchaseAmountChoiceMessage() {
        System.out.println(PURCHASE_AMOUNT_CHOICE);
    }

    public static void printMoneyInputExceptionMessage() {
        System.out.println(ERROR_MESSAGE_HEAD + INVALID_MONEY_INPUT_EXCEPTION);
    }
}
