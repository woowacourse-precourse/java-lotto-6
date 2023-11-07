package lotto.model.validator;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.model.validator.ExceptionHandler.illegalArgument;
import static lotto.model.validator.ExceptionMessage.LOTTO_INCLUDE_6_NUMBERS;
import static lotto.model.validator.ExceptionMessage.PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000;

public class InputValidator {
    private static final Pattern MULTIPLE_1000 = Pattern.compile("[1-9]+0{3}");
    public static void numberMustBeMultipleOf1000(String input){
        if (MULTIPLE_1000.matcher(input).matches()) return;

        illegalArgument(PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000.getMessage());
    }

    public static void lottoMakesSixNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            illegalArgument(LOTTO_INCLUDE_6_NUMBERS.getMessage());
        }
    }
}
