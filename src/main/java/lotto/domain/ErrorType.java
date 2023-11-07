package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import lotto.constant.Condition;
import lotto.constant.Message;

public enum ErrorType {
    NOT_A_NUMBER(Message.ERROR_MSG_NOT_A_NUMBER, input -> {
        try {
            Arrays.stream(input.split(","))
                    .forEach(Integer::parseInt);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }),
    NOT_IN_THOUSANDS(Message.ERROR_MSG_NOT_IN_THOUSANDS, input -> {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .anyMatch(integer -> integer % Condition.THOUSAND != 0);

    }),
    OUT_OF_RANGE(Message.ERROR_MSG_OUT_OF_RANGE, input ->
            Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .anyMatch(number -> Condition.MIN_DRAW_NUMBER > number || number > Condition.MAX_DRAW_NUMBER)
    ),
    LENGTH_NOT_MATCH(Message.ERROR_MSG_LENGTH_NOT_MATCH, input -> input.split(",").length != Condition.WINNING_NUMBERS_COUNT),
    DUPLICATED_NUMBER(Message.ERROR_MSG_DUPLICATED_NUMBER, input -> {
        Set<Integer> isDuplicated = new HashSet<>();
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .anyMatch(integer -> !isDuplicated.add(integer));
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
