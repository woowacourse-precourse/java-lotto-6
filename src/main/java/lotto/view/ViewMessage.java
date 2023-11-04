package lotto.view;

public enum ViewMessage {

    REQUEST_PURCHASE_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("당첨 통계"),
    DIVIDER_MESSAGE("---"),
    NUMBER_OF_PURCHASED_LOTTO_FORMAT("%d개를 구매했습니다."),
    WINNING_MATCHES_THREE_FORMAT("3개 일치 (5,000원) - %d개"),
    WINNING_MATCHES_FOUR_FORMAT("4개 일치 (50,000원) - %d개"),
    WINNING_MATCHES_FIVE_NO_BONUS_FORMAT("5개 일치 (1,500,000원) - %d개"),
    WINNING_MATCHES_FIVE_WITH_BONUS_FORMAT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    WINNING_MATCHES_SIX_FORMAT("6개 일치 (2,000,000,000원) - %d개"),
    TOTAL_RETURN_FORMAT("총 수익률은 %.1f/%입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
