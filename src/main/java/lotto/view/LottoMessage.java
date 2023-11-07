package lotto.view;

public enum LottoMessage {

    //상수("속성값"),
    PURCHASE_PRICE_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT_OUTPUT_MESSAGE("%d개를 구매했습니다.\n"),
    WINNING_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    TOTAL_RETURN_RATE_OUTPUT_MESSAGE("총 수익률은 %.1f%%입니다."),

    WINNING_PRIZE_RESULT_OUTPUT_MESSAGE("당첨 통계\n" +
            "--\n" +
            "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개\n");


    private String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
