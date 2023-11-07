package lotto.domain;

import java.util.List;
import lotto.constant.Message;

public enum Procedure {

    PURCHASE_LOTTO(Message.PURCHASE_MONEY,
            List.of(ErrorType.NOT_ONE_NUMBER, ErrorType.MONEY_CAN_NOT_BE_ZERO, ErrorType.NOT_IN_THOUSANDS)),
    DRAW_WINNING_NUMBERS(Message.WINNING_NUMBERS,
            List.of(ErrorType.NOT_SIX_WINNING_NUMBERS, ErrorType.NUMBER_OUT_OF_RANGE,
                    ErrorType.DUPLICATED_NUMBER)),
    DRAW_BONUS_NUMBER(Message.BONUS_NUMBER, List.of(ErrorType.NOT_ONE_NUMBER, ErrorType.NUMBER_OUT_OF_RANGE));

    private String subject;

    private List<ErrorType> possibleErrors;

    // validate 메소드 내에서 검증이 불가능
    // List<Integer>로 설정되어 있음
    Procedure(String subject, List<ErrorType> errorType) {
        this.subject = subject;
        this.possibleErrors = errorType;
    }

    public void checkPossibleError(List<Integer> numberCandidates) {
        possibleErrors.stream()
                .filter(error -> error.isError(numberCandidates))
                .findFirst()
                .ifPresent(errorType1 -> {
                    throw new IllegalArgumentException(subject + errorType1.getErrorMsg());
                });
    }

}
