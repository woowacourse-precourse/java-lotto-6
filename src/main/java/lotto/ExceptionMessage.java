package lotto;

public enum ExceptionMessage {

    notInteger("[ERROR] 숫자가 입력되야 합니다"),
    negativeValue("[ERROR] 금액은 음수일 수 없습니다"),
    not1000Value("[ERROR] 1000의 배수를 입력해야 합니다");


    private String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}

