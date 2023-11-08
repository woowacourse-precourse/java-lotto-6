package lotto.enums;

public enum PrintMessage {
    REQUEST_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESPONSE_LOTTO_COUNT("%d개를 구매했습니다."),
    RESPONSE_WINNING_STATISTICS("당첨 통계\n---"),
    RESPONSE_WINNING_STATISTICS_FORMAT("%d개 일치 (%s원) - %d개"),
    RESPONSE_WINNING_STATISTICS_FORMAT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    RESPONSE_YIELD("총 수익률은 %s%%입니다.%n");

    private final String message;

    PrintMessage(final String message) {
        this.message = message;
    }

    public String getMassage() {
        return message;
    }
}
