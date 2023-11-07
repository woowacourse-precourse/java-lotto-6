package lotto.message;

public enum ErrorMessage {
    NON_INTEGER_INPUT("정수가 아닌 잘못된 형태의 입력입니다."),
    UNAFFORDABLE_PRICE("지불 금액은 1000원 단위이어야 합니다."),
    WRONG_SIZE_OF_LOTTO("생성된 로또는 6개의 수로 이루어져야 합니다.");


    private String message;
    private String prefix = "[ERROR] ";

    ErrorMessage(String s) {
        this.message = s;
    }

    public String getMessage() {
        return prefix + message;
    }
}