package lotto;

import static lotto.domain.LottoConfig.LOTTO_COUNT;
import static lotto.domain.LottoConfig.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoConfig.LOTTO_MIN_NUMBER;
import static lotto.domain.LottoConfig.LOTTO_PRICE;

public enum ErrorMassage {
    IS_OUT_OF_RANGE_LOTTO_NUMBER(String.format("로또 번호는 %d ~ %d 사이의 숫자여야 합니다.",
            LOTTO_MIN_NUMBER.getValue(), LOTTO_MAX_NUMBER.getValue())),
    IS_NOT_LOTTO_COUNT(String.format("로또 번호는 %d개여야 합니다.", LOTTO_COUNT.getValue())),
    IS_DUPLICATED_LOTTO_NUMBER("중복된 로또 번호가 있습니다."),
    AMOUNT_LESS_THAN_LOTTO_PRICE(String.format("로또 한 장의 가격은 %d원입니다.", LOTTO_PRICE.getValue())),
    AMOUNT_INCORRECT_UNIT(String.format("구매 금액은 %d원 단위여야 합니다.", LOTTO_PRICE.getValue())),
    ;

    private static final String ERROR = "[ERROR] ";
    private final String massage;

    ErrorMassage(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return ERROR + massage;
    }
}
