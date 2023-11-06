package lotto.view;

public enum ViewMessage {
    REQUEST_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    RESPONSE_PURCHASE_AMOUNT("%d개를 구매했습니다."),
    RESPONSE_WINNING_STATISTICS("당첨 통계\n---"),
    RESPONSE_WINNING_STATISTICS_DETAIL("%d개 일치%s (%d원) - %d개"),
    RESPONSE_TOTAL_EARNINGS("총 수익률은 %.2f입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
