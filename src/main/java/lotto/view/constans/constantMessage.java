package lotto.view.constans;

public enum constantMessage {

    // Request
    ASK_PURCHASEAMOUNT("구입금액을 입력해 주세요."),
    ASK_LOTTERYNUMBER("당첨 번호를 입력해 주세요."),

    // Response
    PURCHASED_TICKET_COUNT("개를 구매했습니다.");


    private final String message;

    constantMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}