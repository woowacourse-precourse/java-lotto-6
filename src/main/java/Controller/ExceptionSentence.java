package Controller;

public enum ExceptionSentence {
    NULL_ERROR(""),
    TYPE_ERROR(""),
    BOUNDARY_ERROR("[ERROR] 잘못된 범위 입니다."),
    PRICE_BOUNDARY_ERROR("[ERROR] 구입 금액이 1,000 단위가 아닙니다.");

    private final String MESSAGE;

    ExceptionSentence(String sentence) {
        this.MESSAGE = sentence;
    }

    public String getMessage() {
        return this.MESSAGE;
    }

}
