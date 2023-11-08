package util;

public enum ValidationPriceMessages {

    NOT_A_NUMBER("숫자를 입력해주세요.");

    private String message;

    private ValidationPriceMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
