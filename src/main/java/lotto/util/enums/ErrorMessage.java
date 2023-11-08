package lotto.util.enums;

public enum ErrorMessage {

    ConstructionError("기본 생성자로 생성할 수 없습니다."),
    WINNING_NUMBER_LENGTH_NOT_SIX("당첨 번호는 6개여야합니다."),
    BONUS_NUMBER_IS_NOT_UNIQUE("보너스 번호가 당첨 번호에 존재합니다."),

    NUMBER_CANNOT_PARSE("입력된 값을 정수로 변환할 수 없습니다."),
    NUMBERS_LENGTH_GREATER_THAN_SIX("로또 번호는 6개여야 합니다."),
    NUMBERS_DUPLICATE("로또 번호에 중복된 값이 있습니다."),
    NUMBER_CANNOT_BE_NULL_EMPTY("번호는 비어있거나, NULL이 될 수 없습니다."),
    NUMBER_CANNOT_BE_NEGATIVE("번호는 0 또는 음수가 포함될 수 없습니다."),
    NUMBER_GREATER_THAN_45("입력된 값은 45보다 클 수 없습니다."),

    AMOUNT_CANNOT_BE_LESS_THAN_ZERO("입력된 값은 0보다 커야합니다."),
    AMOUNT_CANNOT_DIVISION("입력된 값을 1,000원 단위로 나눌 수 없습니다."),
    AMOUNT_CANNOT_PARSE("입력된 값을 정수로 변환할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
