package lotto.Lotto.model;

public enum ExceptionGroup {
    INPUT_COUNT_ERROR("[ERROR]로또 번호는 6개 입니다."),
    ;

    private final String error_message;

    ExceptionGroup(String error_message) {
        this.error_message = error_message;
    }

    public String getMessage() {
        return error_message;
    }
}
