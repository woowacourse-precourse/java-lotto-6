package lotto.validator;

import static lotto.constant.ErrorMessage.NOT_NUMBER_MESSAGE;
import static lotto.constant.ErrorMessage.OVER_NUMBER_RANGE_MESSAGE;

import lotto.view.Output;

public class InputValidator {
    //상수들 역할에 따라 분리

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

    public static void inNumberRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Output.errorMessage(OVER_NUMBER_RANGE_MESSAGE);
            throw new IllegalArgumentException(OVER_NUMBER_RANGE_MESSAGE);
        }
    }

//    public static void dividedCountCorrect(String input, String separationSign) {
//        int dividedCount = Arrays.stream(input.split(separationSign))
//                .toList()
//                .size();
//        if (dividedCount != LottoConstant.LOTTO_NUMBER_COUNT) {
//            throw new IllegalArgumentException(NOT_MATCH_COUNT_MESSAGE);
//        }
//    }

}
