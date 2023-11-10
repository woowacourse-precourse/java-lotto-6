package lotto.validates;

import java.util.List;
import lotto.errors.PurchaseError;
import lotto.utils.Util;

public class InputValidate {

    public static void numberValidate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            PurchaseError errorMessage = PurchaseError.NOT_NUMBER;
            throw new IllegalArgumentException(errorMessage.getErrorMessage());
        }
    }

    public static void numbersValidate(String input) {
        List<String> numbers = Util.stringToStringList(input);
        for (String number : numbers) {
            numberValidate(number);
        }
    }

}
