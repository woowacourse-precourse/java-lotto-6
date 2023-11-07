package lotto.controller;

public enum LottoErrorMessage {
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_PURCHASE_INPUT("[ERROR] 구입금액은 1,000원 단위의 정수를 입력해야 합니다.");

    private final String message;
    LottoErrorMessage(String message) {
        this.message = message;
    }

    String getMessage() {
        return this.message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}
