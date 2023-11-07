package lotto.domain;

import java.util.List;
import lotto.constant.Message;

public enum Procedure {

    PURCHASE_LOTTO(Message.PURCHASE_MONEY, List.of(ErrorType.NOT_A_NUMBER, ErrorType.NOT_IN_THOUSANDS)),
    DRAW_WINNING_NUMBERS(Message.WINNING_NUMBERS,
            List.of(ErrorType.LENGTH_NOT_MATCH, ErrorType.NOT_A_NUMBER, ErrorType.OUT_OF_RANGE,
                    ErrorType.DUPLICATED_NUMBER)),
    DRAW_BONUS_NUMBER(Message.BONUS_NUMBER, List.of(ErrorType.NOT_A_NUMBER, ErrorType.OUT_OF_RANGE));

    private String domain;

    private List<ErrorType> possibleErrors;

    Procedure(String domain, List<ErrorType> errorType) {
        this.domain = domain;
        this.possibleErrors = errorType;
    }

    public void checkPossibleError(String input) {
        possibleErrors.stream()
                .filter(error -> error.isError(input))
                .findFirst()
                .ifPresent(errorType1 -> {
                    throw new IllegalArgumentException(domain + errorType1.getErrorMsg());
                });
    }

}
