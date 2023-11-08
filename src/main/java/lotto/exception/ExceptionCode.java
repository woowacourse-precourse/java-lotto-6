package lotto.exception;

public enum ExceptionCode {
    NUMBER_FORMAT("VIEW-001", "[ERROR] 숫자 형식으로 입력해주세요."),

    ;

    private final String code;
    private final String description;

    ExceptionCode(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ExceptionCode{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
