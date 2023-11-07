package lotto;

import lotto.domain.Amount;

import static lotto.domain.number.LottoNumber.MAX_NUMBER;
import static lotto.domain.number.LottoNumber.NIN_NUMBER;

public enum ErrorMessage {

    AMOUNT_IS_NOT_DIVIDED_LOTTO_PRICE(Amount.LOTTO_PRICE + "로 나누어 떨어져야 함. "),
    AMOUNT_IS_NOT_POSITIVE("0 이거나 음수일 수 없음. "),
    AMOUNT_OUT_OF_BOUND("적당히 구매하는 것이 좋습니다. "),
    LOTTOS_IS_EMPTY("로또 번호는 비어있을 수 없음. "),
    NUMBER_NOT_IN_RANGE("당첨 번호는 " + NIN_NUMBER + "~" + MAX_NUMBER + " 사이어야 함. "),
    INPUT_NUMBER("숫자를 입력해주세요. ");

    private static final String PREFIX = "[ERROR]";
    private static final String SUFFIX = "\n";
    private static final String DELIMITER = " ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return String.join(DELIMITER, PREFIX, message, SUFFIX);
    }
}
