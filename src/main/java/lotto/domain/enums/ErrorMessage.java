package lotto.domain.enums;

import static lotto.domain.enums.Constant.LOTTO_MAX_NUMBER;
import static lotto.domain.enums.Constant.LOTTO_MIN_NUMBER;
import static lotto.domain.enums.Constant.LOTTO_PRICE;

public enum ErrorMessage {

    MONEY_AMOUNT_ERROR_MESSAGE(
            String.format(
                    "[ERROR] 구입 금액은 %d원 단위의 양수만 가능합니다.",
                    LOTTO_PRICE.getConstant()
            )
    ),
    NOT_NUMBER_INPUT_ERROR_MESSAGE("[ERROR] 입력은 공백 없이 숫자만 가능합니다."),
    NUMBER_OUT_OF_RANGE_ERROR_MESSAGE(
            String.format(
                    "[ERROR] 로또 번호는 %d과 %d 사이만 가능합니다.",
                    LOTTO_MIN_NUMBER.getConstant(),
                    LOTTO_MAX_NUMBER.getConstant()
            )
    ),
    EXCEED_LENGTH_ERROR_MESSAGE("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_NUMBER_ERROR_MESSAGE("[ERROR] 로또 번호는 중복이 없어야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
