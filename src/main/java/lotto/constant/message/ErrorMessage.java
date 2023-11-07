package lotto.constant.message;

import static lotto.constant.LottoInformation.LOTTO_PRICE;
import static lotto.constant.LottoInformation.MAX_NUMBER;
import static lotto.constant.LottoInformation.MIN_NUMBER;
import static lotto.constant.LottoInformation.NUMBER_COUNT;

public enum ErrorMessage {
    INVALID_BLANK("아무것도 입력하지 않았습니다."),
    INVALID_NUMBER_RANGE("로또 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다."),
    INVALID_COUNT(NUMBER_COUNT + "개의 숫자를 구분자(,)와 함께 입력해주세요."),
    NOT_ONLY_DIGIT("숫자만 입력해주세요."),
    HAS_REMAINDER(LOTTO_PRICE + "원 단위로 넣어주세요."),
    DUPLICATE_BONUS("당첨 번호와 중복될 수 없습니다."),
    DUPLICATE_NUMBER("중복된 숫자가 존재합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
