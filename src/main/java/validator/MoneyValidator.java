package validator;

import static constant.ConstantNumber.LOTTO_PRICE;
import static constant.ExceptionMessage.ERROR_MESSAGE;
import static constant.ExceptionMessage.NON_INTEGER_AMOUNT;
import static constant.ExceptionMessage.NON_MULTIPLE_OF_1000;
import static constant.ExceptionMessage.ZERO_INTEGER_AMOUNT;

public class MoneyValidator {
    private MoneyValidator() {
    }

    public static void isNumeric(String money) {
        try {
            long integerMoney = Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE.getMessage() + NON_INTEGER_AMOUNT.getMessage()
            );
        }
    }

    public static void isZero(String money) {
        long integerMoney = Long.parseLong(money);
        if (integerMoney == 0) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE.getMessage() + ZERO_INTEGER_AMOUNT.getMessage()
            );
        }
    }

    public static void isThousandUnit(String money) {
        long integerMoney = Long.parseLong(money);
        if (integerMoney % LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE.getMessage() + NON_MULTIPLE_OF_1000.getMessage()
            );
        }
    }
}
