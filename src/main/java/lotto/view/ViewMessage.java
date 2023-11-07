package lotto.view;

public enum ViewMessage {
    INPUT_PRICE_MSG("구입금액을 입력해 주세요."),
    INPUT_WINNING_MSG("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_MSG("보너스 번호를 입력해 주세요."),
    OUTPUT_BUYING_FORMAT("%d개를 구매했습니다."),
    OUTPUT_RESULT_TITLE_MSG("당첨 통계\n---"),
    OUTPUT_RESULT_FORMAT("%s (%s) - %d개"),
    OUTPUT_PROFIT_FORMAT("총 수익률은 %.1f%%입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
