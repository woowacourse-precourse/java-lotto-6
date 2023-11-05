package lotto.settings;

import static lotto.settings.LottoSettings.*;

public enum ErrorMessage {
    //숫자인지
    //천원단위인지
    INVALID_NUMBER_FORMAT("[ERROR] 숫자를 입력해야 합니다."),
    INVALID_UNIT_FORMAT("[ERROR] 구입금액은 1,000원 단위여야 합니다"),
    CONTAIN_SPACE("[ERROR] 공백이 포함되어 있습니다."),
    INVALID_COUNT(String.format("[ERROR] 로또번호는 %d개여야 합니다.", SIZE.getNumber())),
    INVALID_RANGE(String.format("[ERROR] 로또 번호는 %d ~ %d 사이여야합니다",MIN_VALUE.getNumber(), MAX_VALUE.getNumber())),
    DUPLICATE_NUM("[ERROR] 중복된 번호가 있습니다.");

    //공백이있는지
    //6개인지
    //로또범위안에있는지
    //중복된번호가있는지
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
