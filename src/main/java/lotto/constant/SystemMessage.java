package lotto.constant;

public enum SystemMessage {

    REQUIRE_PAYMENT_PRICE("구입금액을 입력해 주세요."),
    SAY_TICKET_COUNT_FORMAT("개를 구매했습니다."),
    REQUIRE_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUIRE_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String systemMessage;

    SystemMessage(String systemMessage) {
        this.systemMessage = systemMessage;
    }

    public String getSystemMessage() {
        return systemMessage;
    }
}
