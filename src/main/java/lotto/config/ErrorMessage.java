package lotto.config;

public enum ErrorMessage {
    WRONG_LOTTO_SIZE(String.format("로또 번호는 %d개의 숫자여야 합니다.", LottoConfig.SIZE.value())),
    DUPLICATED_LOTTO("로또 번호는 서로 겹치지 않아야 합니다."),
    WRONG_LOTTO_RANGE(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            LottoConfig.RANGE_START.value(),
            LottoConfig.RANGE_END.value())
    ),
    WRONG_PRICE_RANGE(String.format("구입금액은 최소 %d원 이상이어야 합니다.", LottoConfig.PRICE.value())),
    WRONG_PRICE_DIVISION(String.format("구입금액은 %d원 단위여야 합니다.", LottoConfig.PRICE.value())),
    WRONG_BONUS_RANGE(String.format("보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            LottoConfig.RANGE_START.value(),
            LottoConfig.RANGE_END.value())
    ),
    DUPLICATED_BONUS("보너스 번호는 로또 번호와 겹치지 않아야 합니다."),
    NOT_NUMERIC_STRING("정수형태의 문자열을 입력해야 합니다."),
    OUT_INTEGER_RANGE("Integer 범위내의 정수를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return "[ERROR] " + message;
    }
}
