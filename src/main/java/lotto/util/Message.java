package lotto.util;

public enum Message {

    INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_LUCKY_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    PURCHASE_MESSAGE("%d개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("당첨 통계"),
    RANK_MATCH_MESSAGE("%d개 일치 (%,d원) - %d개%n"),
    RANK_MATCH_NUMBER_5_MESSAGE("%개 일치, 보너스 볼 일치 (%,d원) - %d개%n"),
    GROSS_PROFIT_RATE_MESSAGE("총 수익률은 %.1f입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
