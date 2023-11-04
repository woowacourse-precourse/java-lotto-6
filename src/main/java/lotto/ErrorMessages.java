package lotto;

public enum ErrorMessages {
    ERROR_NOT_NUMBER("[ERROR] 양의 정수를 입력해 주세요"),
    ERROR_NOT_MULTIPLE_OF_UNIT("[ERROR] " + LottoCost.UNIT + "~" + Integer.MAX_VALUE + " 사이의 " + LottoCost.UNIT
            + "의 배수를 입력해 주세요."),
    ERROR_LENGTH_NOT_SIX("[ERROR] 6개의 숫자를 입력해 주세요.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
