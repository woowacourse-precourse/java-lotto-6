package lotto.message;

public enum ErrorMessage {
    NUMBER_SIZE("[ERROR] 숫자는 6개가 되어야 합니다."),
    NUMBER_RANGE("[ERROR] 1과 45 사이의 숫자만 가능합니다."),
    NUMBER_DUPLICATION("[ERROR] 중복된 숫자가 존재합니다."),
    MONEY_AMOUNT("[ERROR] 로또 한장이 1000원이므로 구매금액은 1000원 단위로 입력해야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
