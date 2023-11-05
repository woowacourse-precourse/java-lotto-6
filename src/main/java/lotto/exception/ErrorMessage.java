package lotto.exception;

public enum ErrorMessage {
    // Lotto Validation
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복되지 않아야 합니다."),

    // Winning Lotto Validation
    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복되었습니다."),

    // Lotto Machine Validation
    LESSER_THAN_MINIMUM_MONEY("구입 금액은 0원 이상이여야 합니다."),
    INVALID_INPUT_MONEY_UNIT("구입 금액은 1000원 단위여야 합니다."),

    // Input View Validation
    EMPTY_STRING_EXCEPTION("입력 값이 없습니다."),
    BLANK_STRING_EXCEPTION("입력 값이 비어 있습니다."),
    INPUT_STRING_NOT_NUMBER("숫자만 입력할 수 있습니다."),
    INPUT_STRING_NOT_LOTTO_NUMBER("당첨 번호는 쉼표(,)를 기준으로 구분하여야 합니다."),
    ;


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
