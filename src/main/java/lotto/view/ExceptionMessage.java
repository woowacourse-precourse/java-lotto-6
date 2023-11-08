package lotto.view;

public enum ExceptionMessage {

    inputPurchaseAmountError("[ERROR] 1000에 나누어 떨어지는 숫자를 입력하세요."),
    inputWinningNumbersSizeError("[ERROR] 입력 당첨 금액이 6개가 아닙니다."),
    NumberFormatError("[ERROR] 입력 숫자에 숫자가 아닌 문자가 있습니다."),

    NumberRangeError("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    duplicationError("[ERROR] 중복숫자가 존재합니다.");


    private String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
