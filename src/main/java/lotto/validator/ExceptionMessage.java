package lotto.validator;

public enum ExceptionMessage {
    ERROR_MESSAGE("[ERROR]"),

    INPUT_EMPTY("값을 입력해야 합니다."),
    INPUT_ONLY_NUMBER("숫자만 입력해주세요."),
    INPUT_DIVIDE_ONLY_COMMA("당첨 번호를 ,(쉼표)로 구분해주세요."),

    PURCHASE_PRICE_MULTIPE_1000("구매 금액은 1000원 단위로 입력할 수 있습니다."),

    LOTTO_NUMBER_6_ONLY("로또 번호는 6자로 구성되어야 합니다."),
    LOTTO_NUMBER_UNIQUE("로또 번호는 중복되지 않아야 합니다."),
    LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    BONUS_NUMBER_UNIQUE_WITH_WINNING_NUMBER("보너스 번호와 당첨 번호는 중복되지 않아야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE.message + message;
    }

}
