package validator;

import static constant.ExceptionMessage.ERROR_MESSAGE;
import static constant.ExceptionMessage.NON_INTEGER_AMOUNT;
import static constant.ExceptionMessage.NON_MULTIPLE_OF_1000;

public class MoneyValidator {
    private MoneyValidator() {
    }

    public static void isNumeric(String money) {
        try {
            int integerMoney = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE.getMessage() + NON_INTEGER_AMOUNT.getMessage()
            );
        }
    }

    public static void isThousandUnit(String money) {
        int integerMoney = Integer.parseInt(money);
        if (integerMoney % 1000 != 0) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE.getMessage() + NON_MULTIPLE_OF_1000.getMessage()
            );
        }
    }
}
