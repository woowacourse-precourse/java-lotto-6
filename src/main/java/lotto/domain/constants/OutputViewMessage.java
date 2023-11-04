package lotto.domain.constants;

public enum OutputViewMessage {
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_DETAILS_MESSAGE("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNINGS_STATISTICS_START_MESSAGE("당첨 통계\n---"),
    PROFIT_RATE("총 수익률은 %s%%입니다.");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
