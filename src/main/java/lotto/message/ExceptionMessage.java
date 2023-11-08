package lotto.message;

public enum ExceptionMessage {

    notInteger("[ERROR] 숫자가 입력되야 합니다"),
    negativeValue("[ERROR] 금액은 음수일 수 없습니다"),
    not1000Value("[ERROR] 1000의 배수를 입력해야 합니다"),
    lottoNumber("[ERROR] 로또는 6개의 번호를 가져야 합니다"),
    rangeNumber("[ERROR] 각 숫자는 1 ~ 45 범위 내의 숫자여야 합니다"),
    duplicatedNumber("[ERROR] 숫자에 중복이 있으면 안 됩니다");


    private final String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}

