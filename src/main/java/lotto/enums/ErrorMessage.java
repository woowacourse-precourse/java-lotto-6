package lotto.enums;

import static lotto.enums.Delimiter.COMMA;
import static lotto.enums.LottoConfig.LOTTO_COUNT;
import static lotto.enums.LottoConfig.LOTTO_PRICE;
import static lotto.enums.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.enums.LottoConfig.MIN_LOTTO_NUMBER;

public enum ErrorMessage {
    OUT_OF_RANGE_LOTTO_NUMBER(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue())),
    INVALID_LOTTO_COUNT(String.format("로또 번호는 %d개여야 합니다.", LOTTO_COUNT.getValue())),
    DUPLICATE_LOTTO_NUMBER("중복된 로또 번호가 있습니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호가 로또 번호와 중복되었습니다."),
    NOT_ENOUGH_AMOUNT(String.format("로또 한 장의 가격(%d원)보다 적습니다.", LOTTO_PRICE.getValue())),
    INVALID_AMOUNT_UNIT(String.format("구매 금액은 %d원 단위여야 합니다.", LOTTO_PRICE.getValue())),
    NOT_SEPARATE_BY_DELIMITER(String.format("%s(%s)로 구분되어야 합니다.", COMMA.getKorName(), COMMA.getValue())),
    IS_BLANK("입력값이 비어있습니다."),
    CONTAIN_SPACE("입력값에 공백이 포함되어 있습니다."),
    INVALID_NUMBER("숫자가 아닌 값이 있습니다."),
    ;

    private static final String ERROR = "[ERROR] ";
    private final String massage;

    ErrorMessage(final String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return ERROR + massage;
    }
}
