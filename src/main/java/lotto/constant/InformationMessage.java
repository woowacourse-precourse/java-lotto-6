package lotto.constant;

public enum InformationMessage {
    GUIDE_INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_LOTTO_COUNT_FORMAT("%d개를 구매했습니다."),
    GUIDE_INPUT_WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    ;

    private final String message;

    InformationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
