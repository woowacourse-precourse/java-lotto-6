package lotto.view;

import lotto.domain.LottoRole;

public enum ErrorMessageContainer {
    NOT_VALID_NUMBER("[ERROR] 유효하지 않은 숫자입니다."),
    NOT_VALID_INPUT_FOR_COIN("[ERROR] 구입금액은 1000단위만 허용합니다."),
    NOT_VALID_LOTTO_NUMBER_RANGE(
            "[ERROR] 로또 번호는"
                    + LottoRole.LOTTO_MIN_NUMBER.getNumber()
                    + "부터 "
                    + LottoRole.LOTTO_MAX_NUMBER.getNumber()
                    + " 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 중복된 숫자를 사용할 수 없습니다.");
    private final String message;

    ErrorMessageContainer(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
