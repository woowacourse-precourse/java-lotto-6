package lotto.view;

public enum ViewMessage {
    INPUT_PRICE_MSG("구입금액을 입력해 주세요."),
    OUTPUT_BUYING_MSG("%d개를 구매했습니다."),
    INPUT_WINNING_MSG("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_MSG("보너스 번호를 입력해 주세요."),
    OUTPUT_PRICE_MSG("%s (%s) - %d개"),
    OUTPUT_PROFIT_MSG("총 수익률은 %.1f%%입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
