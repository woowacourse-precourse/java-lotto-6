package lotto.constant;

public enum GeneralMessage {
    ASK_BUY_PRICE("구입금액을 입력해 주세요."),
    NOTIFY_BUY_COUNT("%d개를 구매했습니다."),
    ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    NOTIFY_WINNING_STATISTICS("당첨 통계" + System.lineSeparator() + "---");

    private final String message;

    GeneralMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
