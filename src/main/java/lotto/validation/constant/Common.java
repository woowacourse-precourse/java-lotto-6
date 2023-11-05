package lotto.validation.constant;

public enum Common {

    NULL_MESSAGE("[ERROR] 값에 null이 들어올 수 없습니다."),
    EMPTY_MESSAGE("[ERROR] 값에 빈 값이 들어올 수 없습니다."),
    SPACE_MESSAGE("[ERROR] 값에 공백만 들어올 수 없습니다.");

    private String message;

    Common(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}