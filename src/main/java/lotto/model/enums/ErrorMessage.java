package lotto.model.enums;

import static lotto.Constraints.LOTTO_PRICE;
import static lotto.Constraints.MAX_NUMBER;
import static lotto.Constraints.MIN_NUMBER;
import static lotto.Constraints.SIZE;

public enum ErrorMessage {
    NULL_INPUT_MESSAGE("[ERROR] null은 입력하실 수 없습니다."),
    BLANK_INPUT_MESSAGE("[ERROR] 빈 값은 입력하실 수 없습니다."),
    NOT_INTEGER_INPUT_MESSAGE("[ERROR] 정수를 입력해 주세요."),
    NOT_DIVISIBLE_INTEGER_INPUT_MESSAGE("[ERROR] " + LOTTO_PRICE.getValue() + "단위로 입력해 주세요."),
    NOT_POSITIVE_INTEGER_INPUT_MESSAGE("[ERROR] 양의 정수를 입력해 주세요."),
    NOT_CORRECT_INPUT_MESSAGE("[ERROR] 1, 2, 3, 4, 5, 6과 같은 형식으로 정수를 입력해 주세요."),
    OUT_OF_RANGE_NUMBER_MESSAGE("[ERROR] 로또 번호는 " + MIN_NUMBER.getValue() + "부터 "
            + MAX_NUMBER.getValue() + "사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER_MESSAGE("[ERROR] 중복된 숫자가 존재 합니다."),
    INVALID_SIZE_MESSAGE("[ERROR] 로또 번호는 " + SIZE.getValue() + "개 여야 합니다.");

    private final String message;

    ErrorMessage(String value) {
        this.message = value;
    }

    public String getMessage() {
        return message;
    }
}