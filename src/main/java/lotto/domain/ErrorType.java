package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import lotto.constant.Condition;
import lotto.constant.Message;

public enum ErrorType {
    NOT_ONE_NUMBER(Message.ERROR_NOT_ONE_NUMBER, numberCandidates -> numberCandidates.size() != Condition.ONE_NUMBER),
    NOT_IN_THOUSANDS(Message.ERROR_NOT_IN_THOUSANDS, numberCandidates -> {
        return numberCandidates.stream()
                .anyMatch(amount -> (amount % Condition.THOUSAND) != 0);

    }),
    MONEY_CAN_NOT_BE_ZERO(Message.ERROR_MONEY_CAN_NOT_BE_ZERO, numberCandidates -> {
        return numberCandidates.stream()
                .anyMatch(number -> number == Condition.MIN_LOTTO_MONEY);
    }),
    NUMBER_OUT_OF_RANGE(Message.ERROR_NUMBER_OUT_OF_RANGE, numberCandidates -> {
        return numberCandidates.stream()
                .anyMatch(number -> Condition.MIN_DRAW_NUMBER > number || number > Condition.MAX_DRAW_NUMBER);
    }),
    NOT_SIX_WINNING_NUMBERS(Message.ERROR_NOT_SIX_WINNING_NUMBERS,
            numberCandidates -> numberCandidates.size() != Condition.SIX_WINNING_NUMBERS),
    DUPLICATED_NUMBER(Message.ERROR_DUPLICATED_NUMBER, numberCandidates -> {
        Set<Integer> isDuplicated = new HashSet<>();
        return numberCandidates.stream()
                .anyMatch(number -> !isDuplicated.add(number));
    });

//    NOT_AN_ERROR("정상", null);

    private final String errorMsg;
    private Predicate<List<Integer>> isError;


    ErrorType(String errorMsg, Predicate<List<Integer>> isError) {
        this.errorMsg = errorMsg;
        this.isError = isError;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public boolean isError(List<Integer> numberCandidates) {
        return isError.test(numberCandidates);
    }
}
