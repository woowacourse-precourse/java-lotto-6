package lotto.enums;

import static lotto.domain.LottoConfig.LOTTO_COUNT;
import static lotto.domain.LottoConfig.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoConfig.LOTTO_MIN_NUMBER;
import static lotto.domain.LottoConfig.LOTTO_PRICE;
import static lotto.enums.Delimiter.*;

public enum ErrorMassage {
    OUT_OF_RANGE_LOTTO_NUMBER(String.format("로또 번호는 %d ~ %d 사이의 숫자여야 합니다.",
            LOTTO_MIN_NUMBER.getValue(), LOTTO_MAX_NUMBER.getValue())),
    INCORRECT_LOTTO_COUNT(String.format("로또 번호는 %d개여야 합니다.", LOTTO_COUNT.getValue())),
    DUPLICATE_LOTTO_NUMBER("중복된 로또 번호가 있습니다."),
    NOT_ENOUGH_AMOUNT(String.format("로또 한 장의 가격(%d원)보다 적습니다.", LOTTO_PRICE.getValue())),
    INCORRECT_AMOUNT_UNIT(String.format("구매 금액은 %d원 단위여야 합니다.", LOTTO_PRICE.getValue())),
    NOT_SEPARATE_BY_DELIMITER(String.format("%s(%s)로 구분되어야 합니다.", COMMA.getKorName(), COMMA.getValue())),
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
