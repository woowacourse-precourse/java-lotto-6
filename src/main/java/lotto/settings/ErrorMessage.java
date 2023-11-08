package lotto.settings;

import static lotto.settings.LottoSettings.*;

public enum ErrorMessage {

    INVALID_NUMBER_FORMAT("[ERROR] 숫자를 입력해야 합니다."),
    INVALID_UNIT_FORMAT("[ERROR] 구입금액은 1,000원 단위여야 합니다"),
    CONTAIN_SPACE("[ERROR] 공백이 포함되어 있습니다."),
    HAS_COMMA_ON_BOTH_SIDES("[ERROR] ','는 숫자사이에만 있어야합니다."),
    INVALID_COUNT(String.format("[ERROR] 로또번호는 %d개여야 합니다.", LOTTO_NUMBER_SIZE.getNumber())),
    INVALID_RANGE(String.format("[ERROR] 로또 번호는 %d ~ %d 사이여야합니다",MIN_VALUE.getNumber(), MAX_VALUE.getNumber())),
    DUPLICATE_NUM("[ERROR] 중복된 번호가 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
