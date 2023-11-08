package lotto.enums;

import static lotto.enums.LottoInfo.*;

public enum ErrorMessage {
    NULL_ERROR("비정상적인 입력입니다."),
    NOT_NATURAL_NUMBER("자연수를 입력해주세요."),
    NOT_MULTIPLE_OF_LOTTO_PRICE(LOTTO_PRICE + "의 배수만 입력해주세요."),
    NOT_EQUAL_LOTTO_LENGTH(NUMBERS_PER_LOTTO + "개의 수를 입력해주세요."),
    NOT_DISTINCT_LIST("중복된 수는 입력하지 말아주세요."),
    ALREADY_INCLUDED_NUMBER("이미 당첨번호에 있는 숫자입니다."),
    NOT_IN_RANGE(MIN_NUMBER + "부터 " +
            MAX_NUMBER + "까지의 수만 입력해주세요.");

    private final String message;
    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
