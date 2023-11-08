package lotto.constant;

public enum ProgressMessage {
    PURCHASE_AMOUNT_REQUEST("구입금액을 입력해 주세요."),
    PUBLISHED_NUM_OF_LOTTO("%s개를 구매했습니다."),
    WINNING_NUMBERS_REQUEST("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST("\n보너스 번호를 입력해 주세요."),
    RESULT_STATISTICS("\n당첨 통계\n---"),
    WINNING_RESULT("%d개 일치 (%,d원) - %d개"),
    BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    BONUS_NUMBER_ALREADY_EXISTS("보너스 번호가 이미 당첨 번호에 존재합니다."),
    EARNING_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    ProgressMessage(final String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }
}
