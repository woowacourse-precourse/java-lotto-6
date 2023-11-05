package lotto.common;

/**
 * @Enum : 출력 메시지 타입
 */
public enum MessageType {

    ASK_PURCHASE_AMOUNT("구매금액을 입력해 주세요."),
    PURCHASED_LOTTO_FORMAT("%d개를 구매했습니다."),
    ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    WINNING_STATISTICS_FORMAT("%d개 일치 (%s원) - %d개"),
    ;

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getEaMessage(int ea) {
        return String.format(PURCHASED_LOTTO_FORMAT.getMessage(), ea);
    }

    public String getStatisticsMessage(int matchCount, int money, int ea) {
        return String.format(
                WINNING_STATISTICS_FORMAT.message,
                matchCount,
                String.format("%,d", money),
                ea
        );
    }
}
