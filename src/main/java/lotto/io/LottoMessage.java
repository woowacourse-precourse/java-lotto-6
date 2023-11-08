package lotto.io;

public enum LottoMessage {

    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    PRINT_LOTTO_COUNT("\n%d개를 구매했습니다.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
