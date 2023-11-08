package lotto.model.validator;

public enum ExceptionMessage {
    START_MESSAGE("[ERROR] "),

    EMPTY_INPUT("값을 입력하지 않으셨습니다."),
    INPUT_MUST_BE_NUMERIC("입력 값은 숫자만 가능합니다."),
    INPUT_MUST_BE_NUMERIC_WITH_COMMA("6가지의 숫자들과 쉼표만 입력 가능합니다."),

    PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000("1000원 단위로 구입하실 수 있습니다."),
    LOTTO_INCLUDES_6_NUMBERS("로또 번호는 6가지 숫자로 이뤄져 있습니다."),
    LOTTO_INCLUDES_UNIQUE_NUMBERS("로또 번호는 서로 다른 6자로 이뤄져 있습니다."),
    LOTTO_RANGE_IS_1_TO_45("로또 번호는 1부터 45 사이의 숫자로 이뤄져 있습니다."),

    BONUS_NUMBER_MUST_UNIQUE_WITH_WINNING_NUMBER("보너스 번호는 로또 당첨 번호와 중복 되지 않아야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return START_MESSAGE.message + message;
    }
}
