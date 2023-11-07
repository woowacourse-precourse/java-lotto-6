package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import lotto.constant.Condition;
import lotto.constant.Message;

public enum ErrorType {
    NOT_A_NUMBER(Message.ERROR_NOT_A_NUMBER, input -> {
        try {
            Arrays.stream(input.split(","))
                    .forEach(Long::parseLong);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }),
    NOT_IN_THOUSANDS(Message.ERROR_NOT_IN_THOUSANDS, input -> {
        return Arrays.stream(input.split(","))
                .map(Long::parseLong)
                .anyMatch(amount -> amount % Condition.THOUSAND != 0);

    }),
    MONEY_OUT_OF_RANGE(Message.ERROR_MONEY_OUT_OF_RANGE, input ->
            Arrays.stream(input.split(","))
                    .map(Long::parseLong)
                    .anyMatch(number -> Condition.MIN_LOTTO_MONEY > number)
    ),
    NUMBER_OUT_OF_RANGE(Message.ERROR_NUMBER_OUT_OF_RANGE, input ->
            Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .anyMatch(number -> Condition.MIN_DRAW_NUMBER > number || number > Condition.MAX_DRAW_NUMBER)
    ),
    NOT_SIX_WINNING_NUMBERS(Message.ERROR_NOT_SIX_WINNING_NUMBERS, input -> input.split(",").length != Condition.WINNING_NUMBERS_COUNT),
    NOT_ONE_NUMBER(Message.ERROR_NOT_ONE_NUMBER, input -> input.split(",").length != Condition.NUMBER_COUNT),
    DUPLICATED_NUMBER(Message.ERROR_DUPLICATED_NUMBER, input -> {
        Set<Long> isDuplicated = new HashSet<>();
        return Arrays.stream(input.split(","))
                .map(Long::parseLong)
                .anyMatch(number -> !isDuplicated.add(number));
    });

//    NOT_AN_ERROR("정상", null);

    private final String errorMsg;
    private Predicate<String> isError;


    ErrorType(String errorMsg, Predicate<String> isError) {
        this.errorMsg = errorMsg;
        this.isError = isError;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public boolean isError(String input){
        return isError.test(input);
    }
}
