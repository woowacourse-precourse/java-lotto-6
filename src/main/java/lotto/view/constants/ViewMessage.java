package lotto.view.constants;

public enum ViewMessage {
    PAY_AMOUNT_INPUT("구입금액을 입력해 주세요."),
    PURCHASED_LOTTO("%d개를 구매했습니다.\n"),
    WINNING_NUMBER_INPUT("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("\n보너스 번호를 입력해 주세요."),
    LOTTO_RESULT("\n당첨 통계\n--- "),
    FIFTH_PRIZE("3개 일치 (5,000원) - %d개\n"),
    FORTH_PRIZE("4개 일치 (50,000원) - %d개\n"),
    THIRD_PRIZE("5개 일치 (1,500,000원) - %d개\n"),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST_PRIZE("6개 일치 (2,000,000,000원) - %d개\n"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
