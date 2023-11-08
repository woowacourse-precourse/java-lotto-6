package lotto.view;

import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.NOT_NUMBER;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.OVER_RANGE;
import static lotto.view.constant.ViewConstant.InputViewConstant.MAX_RANGE;
import static lotto.view.constant.ViewConstant.InputViewConstant.MIN_RANGE;
import static lotto.view.constant.ViewConstant.InputViewConstant.ONLY_CONTAINS_NUMBER_REGEX;

import camp.nextstep.edu.missionutils.Console;

public interface InputViewable {
    void validate(String input);

    default String receiveInput() {
        String input = Console.readLine();
        validate(input);

        return input;
    }

    default void validateLottoNumber(final String number) {
        if (isNotContainsOnlyNumber(number)) {
            throw new IllegalArgumentException(NOT_NUMBER.getErrorMessage());
        }

        final int parsedNumber = Integer.parseInt(number);
        if (parsedNumber < MIN_RANGE || parsedNumber > MAX_RANGE) {
            throw new IllegalArgumentException(OVER_RANGE.getErrorMessage());
        }
    }

    default boolean isNotContainsOnlyNumber(final String input) {
        return !input.matches(ONLY_CONTAINS_NUMBER_REGEX);
    }
}
