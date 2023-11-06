package lotto.config;

public enum ErrorMessage {
    EMPTY("공백 문자열을 입력했습니다."),
    CONTAIN_IMPROPER_LETTER("부적절한 값을 입력했습니다."),
    EXIST_REMAINDER("구입금액은 " + LottoConfig.LOTTO_UNIT_PRICE.getNumber() + "원으로 나누어 떨어져야 합니다."),
    INVALID_FORMAT("당첨 번호는 " + LottoConfig.LOTTO_NUMBER_COUNT.getNumber() + "개의 숫자를 쉼표(,)로 구분하여 입력해야 합니다."),
    DUPLICATE_NUMBER("당첨 번호는 중복 입력할 수 없습니다."),
    EXIST_NUMBER("보너스 번호는 당첨번호와 중복될 수 없습니다."),
    OUT_RANGE_NUMBER("로또 번호는 "
            + LottoConfig.LOTTO_NUMBER_MIN.getNumber() + "부터 "
            + LottoConfig.LOTTO_NUMBER_MAX.getNumber() + " 사이의 숫자여야 합니다."
    );

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
