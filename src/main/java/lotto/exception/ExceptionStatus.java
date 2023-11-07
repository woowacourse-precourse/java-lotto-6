package lotto.exception;

public enum ExceptionStatus {
    OCCURRED("예외 발생"),
    NOT_OCCURRED("예외 미발생");

    private final String description;

    ExceptionStatus(String description) {
        this.description = description;
    }

    public boolean isOccurred() {
        return this == OCCURRED;
    }
}
