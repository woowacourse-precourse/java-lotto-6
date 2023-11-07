package lotto.view;

import static lotto.message.ErrorMessage.ERROR_MESSAGE_HEAD;
import static lotto.message.ErrorMessage.INVALID_MONEY_FORMAT_EXCEPTION;
import static lotto.message.InfoMessage.*;

public class Printer {
    public static void printPurchaseAmountChoiceMessage() {
        System.out.println(PURCHASE_AMOUNT_CHOICE);
    }

    public static void printMoneyFormatExceptionMessage() {
        System.out.println(ERROR_MESSAGE_HEAD + INVALID_MONEY_FORMAT_EXCEPTION);
    }
}
