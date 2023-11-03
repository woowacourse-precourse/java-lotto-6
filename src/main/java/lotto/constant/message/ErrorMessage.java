package lotto.constant.message;

import static lotto.constant.LottoInformation.LOTTO_PRICE;
import static lotto.constant.LottoInformation.MAX_NUMBER;
import static lotto.constant.LottoInformation.MIN_NUMBER;

public enum ErrorMessage {
    BLANK_LINE("아무것도 입력하지 않았습니다."),
    NOT_ONLY_DIGIT("숫자만 입력해주세요."),
    HAS_REMAINDER(LOTTO_PRICE + "원 단위로 넣어주세요."),
    DUPLICATE_BONUS("당첨 번호와 중복될 수 없습니다."),
    INVALID_NUMBER_RANGE(MIN_NUMBER + " ~ " + MAX_NUMBER + "사이의 숫자가 아닙니다"),
    DUPLICATE_NUMBER("중복된 숫자가 존재합니다."),
    NOT_MONEY("주머니를 뒤적였지만 돈이 없습니다..");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
