package lotto.validator;

import static lotto.constant.ErrorMessage.COMMA_COUNT_DIFFERENT_MESSAGE;
import static lotto.constant.ErrorMessage.NOT_NUMBER_MESSAGE;
import static lotto.constant.ErrorMessage.OVER_NUMBER_RANGE_MESSAGE;
import static lotto.view.Input.SEPARATION_SIGN;

import lotto.constant.LottoConstant;
import lotto.view.Output;

/*
 *   입력값의 검증을 담당
 * */

public class InputValidator {

    private static final int NECESSARY_COMMA_COUNT = LottoConstant.LOTTO_NUMBER_COUNT - 1;

    private static final String NUMBER_REGEX = "[0-9]+";


    public static void notNumber(String input) {
        if (isNotMatchRegex(input)) {
            Output.errorMessage(NOT_NUMBER_MESSAGE);
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    private static boolean isNotMatchRegex(String input) {
        if (input.matches(InputValidator.NUMBER_REGEX)) {
            return false;
        }
        return true;
    }

    public static void overNumberRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Output.errorMessage(OVER_NUMBER_RANGE_MESSAGE);
            throw new IllegalArgumentException(OVER_NUMBER_RANGE_MESSAGE);
        }
    }

    public static void commaCountDifferent(String input) {
        long count = input.chars()
                .filter(c -> c == SEPARATION_SIGN)
                .count();
        if ((int) count != NECESSARY_COMMA_COUNT) {
            System.out.println(COMMA_COUNT_DIFFERENT_MESSAGE);
            throw new IllegalArgumentException(COMMA_COUNT_DIFFERENT_MESSAGE);
        }
    }
}
