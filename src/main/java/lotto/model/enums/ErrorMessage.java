package lotto.model.enums;

import static lotto.Constraints.LOTTO_PRICE;

public enum ErrorMessage {
    NULL_INPUT_MESSAGE("null은 입력하실 수 없습니다."),
    BLANK_INPUT_MESSAGE("빈 값은 입력하실 수 없습니다."),
    NOT_INTEGER_INPUT_MESSAGE("정수를 입력해 주세요."),
    NOT_DIVISIBLE_INTEGER_INPUT_MESSAGE(LOTTO_PRICE.getValue() + "단위로 입력해 주세요."),
    NOT_POSITIVE_INTEGER_INPUT_MESSAGE("양의 정수를 입력해 주세요."),
    NOT_CORRECT_INPUT_MESSAGE("1, 2, 3, 4, 5, 6과 같은 형식으로 정수를 입력해 주세요.");

    private final String message;

    ErrorMessage(String value) {
        this.message = value;
    }

    public String getMessage() {
        return message;
    }
}