package lotto.model.validator;

import java.util.regex.Pattern;

import static lotto.model.validator.ExceptionMessage.PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000;

public class InputValidator {
    private static final Pattern MULTIPLE_1000 = Pattern.compile("[1-9]+0{3}");
    public static void numberMustBeMultipleOf1000(String input){
        if (MULTIPLE_1000.matcher(input).matches()) return;

        ExceptionHandler.illegalArgument(PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000.getMessage());
    }
}
