package lotto.constant;

public enum OutputMessage {

    GET_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    BOUGHT_LOTTO_PACK("%d개를 구매했습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
