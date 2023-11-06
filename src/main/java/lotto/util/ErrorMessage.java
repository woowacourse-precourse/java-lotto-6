package lotto.util;

public enum ErrorMessage {
    SIZE("[ERROR] 1000원 이상 20억원 미만의 금액을 입력하시오"),
    NUMBER("[ERROR] 숫자를 입력하시오"),
    RANGE("[ERROR] 20억원 미만의 금액을 입력하시오"),
    UNIT("[ERROR] 1000원 단위의 금액을 입력하시오");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
