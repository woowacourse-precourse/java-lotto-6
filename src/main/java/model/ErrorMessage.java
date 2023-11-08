package model;

public enum ErrorMessage {

    WRONG_ORDER_PRICE("[ERROR] 로또는 1000원 단위로 구매할 수 있습니다."),
    REDUNDANT_NUMBER("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    WRONG_ORDER_COUNT("[ERROR] 로또 번호는 6개 입력해야 합니다."),
    WRONG_ORDER_CHRACTER("[ERROR] 금액은 숫자만 입력 가능합니다."),
    WRONG_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
