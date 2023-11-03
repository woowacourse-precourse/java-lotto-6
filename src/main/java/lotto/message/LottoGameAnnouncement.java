package lotto.message;

public enum LottoGameAnnouncement {
    ASK_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    ;

    private final String message;

    LottoGameAnnouncement(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
