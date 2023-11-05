package lotto.constant;

public enum OutputMessage {

    GET_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    BOUGHT_LOTTO_PACK("%d개를 구매했습니다."),
    GET_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
