package lotto.utils;

import static lotto.utils.Constants.ERROR_PREFIX;

public enum LottoMessages {
    WRONG_WINNING_NUMBERS(ERROR_PREFIX + "당첨번호 6개와 보너스 번호 1개를 입력해주세요. 번호는 숫자,로 이루어져있어야 합니다."),
    WRONG_NUMBER(ERROR_PREFIX + "숫자를 입력해주세요."),
    PRICE_ZERO(ERROR_PREFIX + "금액은 0이 될 수 없습니다."),
    PRICE_DIVIDE_BY_LOTTO_PRICE(ERROR_PREFIX + "로또 금액으로 나누어져야 합니다."),
    OUT_OF_LOTTO_NUMBER_BOUND(ERROR_PREFIX + "1 이상 45 이하의 숫자를 입력해야 합니다."),
    DUPLICATE_NUMBER(ERROR_PREFIX + "중복된 숫자는 입력할 수 없습니다."),
    DIVIDE_BY_ZERO(ERROR_PREFIX + "0으로 나눌 수 없습니다.")

    ;

    private final String kr;
    LottoMessages(String givenKr) {
        this.kr = givenKr;
    }

    public String getKr() {
        return this.kr;
    }
}
