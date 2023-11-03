package lotto.ui.message;

public enum OutputMessage {

    GET_PURCHASE_MONEY("구입금액을 입력해 주세요."),

    PRINT_LOTTO_COUNT("개를 구매했습니다.");
    ;

    private final String comment;

    OutputMessage(String comment) {
        this. comment = comment;
    }

    public String getComment() {
        return this.comment;
    }
}
