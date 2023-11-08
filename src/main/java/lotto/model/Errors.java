package lotto.model;

public enum Errors {
    COMMON("[ERROR] "),
    INPUT_K("1000원 단위의 금액을 입력하세요."),
    RANGE("1 ~ 45의 숫자를 입력하세요."),
    INTEGER("정수형의 숫자를 입력하세요."),
    BONUS("로또 번호와 중복되지 않는 보너스 번호를 입력하세요."),
    LOTTO("로또 번호를 다시 입력하세요.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }
    public String getMessage() {
     return COMMON.message + this.message;
    }
}
