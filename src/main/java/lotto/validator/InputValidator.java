package lotto.validator;

import static lotto.constant.ErrorMessage.NOT_NUMBER_MESSAGE;
import static lotto.constant.ErrorMessage.OVER_RANGE_MESSAGE;

import lotto.view.Output;

public class InputValidator {

    private static final String NUMBER_REGEX = "[0-9]+";

    public static void onlyNumber(String input) {
        if (isNotMatchRegex(input, NUMBER_REGEX)) {
            Output.errorMessage(NOT_NUMBER_MESSAGE);
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    //긍적의 조건문을 나타내기위한 함수 필요한가?
    //util로 빼줘야하나
    private static boolean isNotMatchRegex(String input, String regex) {
        if (input.matches(regex)) {
            return false;
        }
        return true;
    }

    public static void inRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Output.errorMessage(OVER_RANGE_MESSAGE);
            throw new IllegalArgumentException(OVER_RANGE_MESSAGE);
        }
    }

}
