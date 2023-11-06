package lotto.messages;

import static lotto.configuration.IntegerConstants.MAX_NUMBER_COUNT_OF_LOTTO;
import static lotto.configuration.IntegerConstants.MAX_NUMBER_RANGE;
import static lotto.configuration.IntegerConstants.MIN_NUMBER_RANGE;

public enum ErrorMessages {

    INVALID_INTEGER_MESSAGE("1 이상 2,147,483,647 이하의 정수 값이 필요합니다."),
    INVALID_MULTIPLE_OF_1000_MESSAGE("1000의 배수인 숫자가 필요합니다."),
    EMPTY_MESSAGE("하나 이상의 값이 필요합니다."),
    DUPLICATE_NAME_MESSAGE("중복된 값은 입력할 수 없습니다."),
    INVALID_LOTTO_NUMBER_COUNT_MESSAGE(MAX_NUMBER_COUNT_OF_LOTTO.getValue() + "개의 값이 필요합니다."),
    INVALID_LOTTO_NUMBER_RANGE_MESSAGE(
            MIN_NUMBER_RANGE.getValue() + "부터 "
                    + MAX_NUMBER_RANGE.getValue() + "사이의 값이 필요합니다.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
