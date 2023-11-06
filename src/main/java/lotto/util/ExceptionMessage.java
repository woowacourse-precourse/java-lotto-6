package lotto.util;

import static lotto.util.Constants.LOTTO_ONE_GAME_PRICE;

public enum ExceptionMessage {
    INVALID_LOTTO_SIZE("로또 번호는 6개로 구성되어야 합니다."),
    INVALID_INPUT_NUMERIC("입력값은 숫자만 입력 할 수 있습니다."),
    INVALID_UNIT_OF_BUDGET(String.format("금액은 %d원 단위로 입력해야 합니다.", LOTTO_ONE_GAME_PRICE));

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }

}
