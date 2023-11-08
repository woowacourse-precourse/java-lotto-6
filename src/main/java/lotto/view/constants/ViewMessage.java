package lotto.view.constants;

public enum ViewMessage {
    GET_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_PURCHASE_NOTICE_MESSAGE("%d개를 구매했습니다."),
    GET_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER("보너스 번호를 입력해 주세요.");
    private final String message;

    ViewMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
