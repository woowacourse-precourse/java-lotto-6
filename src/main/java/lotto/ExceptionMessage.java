package lotto;

public enum ExceptionMessage {
    ILLEGAL_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_OR_NOT6("[ERROR] 로또 번호에 중복된 숫자가 있거나, 로또 번호가 6자리가 아닙니다."),
    NOT_DIVDE_1000("[ERROR] 금액은 1000원 단위여야 합니다.")
    ;

    private final String label;

    ExceptionMessage(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
