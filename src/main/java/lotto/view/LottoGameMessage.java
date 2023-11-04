package lotto.view;

public enum LottoGameMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    COUNT_OF_PURCHASED_LOTTO("%d개를 구매했습니다."),
    REQUEST_WINNING_LOTTO_NUMBERS("당첨 번호를 입력해 주세요.");

    private final String message;

    LottoGameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
