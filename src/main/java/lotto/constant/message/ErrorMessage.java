package lotto.constant.message;

import static lotto.constant.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoNumber.LOTTO_NUMBER_LENGTH;

public enum ErrorMessage {
    NON_INTEGER("올바른 숫자를 입력해 주세요."),
    INVALID_RANGE_NUMBER(MINIMUM_LOTTO_NUMBER.getNumber() + "에서 " + MAXIMUM_LOTTO_NUMBER.getNumber() + "사이의 번호를 입력해 주세요."),
    NOT_PURCHASE_UNIT("1,000단위의 금액을 입력해 주세요."),
    INVALID_LENGTH_LOTTO_NUMBER(LOTTO_NUMBER_LENGTH.getNumber() + "자리의 번호를 입력해 주세요."),
    DUPLICATE_NUMBER("번호는 중복될 수 없습니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");


    public static final String ERROR = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(ERROR, message);
    }

    public String getMessage() {
        return message;
    }
}
