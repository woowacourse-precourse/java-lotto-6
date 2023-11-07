package lotto.validator;

import lotto.message.ErrorMessageFormatter;

import static lotto.message.ErrorMessageFormatter.*;

public class UserTicketValidator {

    private UserTicketValidator() {
    }

    public static void validateTicketPrice(String price) {
        validateTicketPriceInteger(price);
        validateTicketPriceIsMultiple(price);
        validateTicketPriceCount(price);
    }

    public static void validateTicketPriceInteger(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage("가격정보는 정수만 입력될 수 있습니다."));
        }
    }

    public static void validateTicketPriceIsMultiple(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(errorMessage("가격 정보는 1000단위로 입력할 수 있습니다."));
        }
    }

    public static void validateTicketPriceCount(String input) {
        int price = Integer.parseInt(input);
        if (price / 1000 <= 0) {
            throw new IllegalArgumentException(errorMessage("로또는 1개 이상구매해야합니다."));
        }
    }

}
