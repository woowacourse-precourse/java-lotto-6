package lotto;

public enum Error {
    EMPTY_INPUT("입력값이 없습니다. 다시 입력해주세요."),
    CONTAINS_BLANK("공백을 포함할 수 없습니다. 공백 없이 입력해주세요."),
    CONTAINS_NOT_NUMBER("숫자 외에 입력할 수 없습니다. 숫자만 입력해주세요."),
    CONTAINS_NOT_NUMBER_COMMA("숫자 또는 콤마(,) 외에 입력할 수 없습니다. 숫자 또는 콤마(,)만 입력해주세요."),
    NOT_PLUS_SIGN("0 또는 음수를 입력할 수 없습니다. 양수를 입력해주세요."),
    CONTAINS_CONTINUAL_COMMA("콤마(,)를 연속해서 입력할 수 없습니다. 한 개씩만 입력해주세요."),
    WITH_COMMA_EDGE("양끝에 콤마(,)를 입력할 수 없습니다. 양끝에는 숫자를 입력해주세요."),
    TOO_SMALL(String.format("%d보다 작은 수를 입력할 수 없습니다. %d 이상의 수를 입력해주세요.", NumberConstants.MIN_NUMBER, NumberConstants.MIN_NUMBER)),
    TOO_LARGE(String.format("%d보다 큰 수를 입력할 수 없습니다. %d 이하의 수를 입력해주세요.", NumberConstants.MAX_NUMBER, NumberConstants.MAX_NUMBER)),
    CONTAINS_DUPLICATE("로또 번호는 서로 중복될 수 없습니다. 서로 중복되지 않게 입력해주세요."),
    NOT_LOTTO_SIZE(String.format("로또 번호의 개수가 %d개가 아닙니다. %d개의 번호를 입력해주세요.", NumberConstants.LOTTO_SIZE, NumberConstants.LOTTO_SIZE)),
    NOT_IN_RANGE(String.format("로또 번호 범위 외의 수를 포함할 수 없습니다. %d이상 %d이하의 수만 입력해주세요.", NumberConstants.MIN_NUMBER, NumberConstants.MAX_NUMBER));

    private static final String ERROR = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + this.message;
    }
}
