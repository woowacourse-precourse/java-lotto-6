package lotto.utils;

public enum GameMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASED_TICKET_COUNT("%d개를 구매했습니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
