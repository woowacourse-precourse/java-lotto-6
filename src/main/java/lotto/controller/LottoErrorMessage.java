package lotto.controller;

public enum LottoErrorMessage {
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_PURCHASE_INPUT("[ERROR] 구입금액은 1,000원 단위의 정수를 입력해야 합니다."),
    INVALID_LOTTO_NUMBER_INPUT("[ERROR] 로또 번호는 6개의 숫자로 구성되어야 합니다."),
    INVALID_LOTTO_NUMBER_DUPLICATION("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_TYPE("[ERROR] 올바르지 않은 로또 번호 형식입니다.");

    private final String message;
    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}
