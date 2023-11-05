package lotto;

import static lotto.domain.LottoConfig.LOTTO_COUNT;
import static lotto.domain.LottoConfig.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoConfig.LOTTO_MIN_NUMBER;

public enum ErrorMassage {
    IS_OUT_OF_RANGE_LOTTO_NUMBER(String.format("로또 번호는 %d ~ %d 사이의 숫자여야 합니다.",
            LOTTO_MIN_NUMBER.getValue(), LOTTO_MAX_NUMBER.getValue())),
    IS_NOT_LOTTO_COUNT(String.format("로또 번호는 %d개여야 합니다.", LOTTO_COUNT.getValue())),
    IS_DUPLICATED_LOTTO_NUMBER("중복된 로또 번호가 있습니다.");

    private static final String ERROR = "[ERROR] ";
    private final String massage;

    ErrorMassage(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return ERROR + massage;
    }
}
