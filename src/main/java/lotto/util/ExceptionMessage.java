package lotto.util;

public enum ExceptionMessage {
    INVALID_INPUT_FORMAT("값은 정수로만 입력할 수 있습니다."),
    INVALID_PURCHASE_UNIT("구매 금액은 1000 단위로 입력해주세요."),
    INVALID_PURCHASE_MIN_RANGE("구매 금액은 1000 이상의 자연수로 입력해주세요."),
    INVALID_PURCHASE_MAX_RANGE("구매 금액은 2147483000 이하의 자연수로 입력해주세요."),
    INVALID_LOTTO_NUMBER_MIN_RANGE("당첨 번호는 1 이상의 자연수를 입력해주세요."),
    INVALID_LOTTO_NUMBER_MAX_RANGE("당첨 번호는 45 이하의 자연수를 입력해주세요."),
    INVALID_WINNING_NUMBER_COUNT("당첨 번호는 1부터 45 사이의 숫자를 6개 입력해야합니다."),
    INVALID_BONUS_NUMBER_COUNT("보너스 번호는 1부터 45 사이의 숫자를 1개만 입력할 수 있습니다."),
    DUPLICATED_WINNING_NUMBER("입력한 당첨 번호 중, 중복된 번호가 있습니다."),
    DUPLICATED_BONUS_NUMBER("입력한 보너스 번호가 당첨 번호와 중복됩니다."),;

    public static final String BASE_MESSAGE = "[ERROR] %s";

    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}
