package lotto.validator;

public enum ExceptionMessages {
    NON_NUMERIC_INPUT("[ERROR] 입력 값은 숫자이어야 합니다");

    private final String message;
    private final String errorFormat = "[ERROR] %s";


    ExceptionMessages(String message) {
        this.message = String.format(errorFormat, message);
    }

    public String getErrorMessage() {
        return message;
    }
}
