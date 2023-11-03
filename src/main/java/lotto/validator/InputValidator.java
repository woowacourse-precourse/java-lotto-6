package lotto.validator;

import static lotto.constant.ErrorMessage.NOT_DIVISIBLE_MESSAGE;
import static lotto.constant.ErrorMessage.NOT_NUMBER_MESSAGE;
import static lotto.constant.ErrorMessage.OVER_RANGE_MESSAGE;
import static lotto.constant.LottoConstant.LOTTO_PRICE;

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

    public static void inRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Output.errorMessage(OVER_RANGE_MESSAGE);
            throw new IllegalArgumentException(OVER_RANGE_MESSAGE);
        }
    }

    public static void divisibleUnit(int price) {
        if (isNotDivisibleUnit(price)) {
            Output.errorMessage(NOT_DIVISIBLE_MESSAGE);
            throw new IllegalArgumentException(NOT_DIVISIBLE_MESSAGE);
        }
    }

    private static boolean isNotDivisibleUnit(int price) {
        //상수화를 시키는 것이 오히려 가독성을 떨어뜨리는 느낌?
        if ((price % LOTTO_PRICE == 0) && (price != 0)) {
            return false;
        }
        return true;
    }

}
