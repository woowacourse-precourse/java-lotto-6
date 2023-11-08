package lotto.LottoPlayer.model;

public enum UIMessageGroup {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASED_LOTTO_NUMBER("%d개를 구매했습니다."),
    STATISTICS_RESULT("\n당첨 통계\n" + "---"),
    FIRST_PRIZE_RESULT("6개 일치 (2,000,000,000원) - %d개"),
    SECOND_PRIZE_RESULT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD_PRIZE_RESULT("5개 일치 (1,500,000원) - %d개"),
    FOURTH_PRIZE_RESULT("4개 일치 (50,000원) - %d개"),
    FIFTH_PRIZE_RESULT("3개 일치 (5,000원) - %d개"),
    PROFIT_RATE_RESULT("총 수익률은 %.1f%%입니다.");

    private String message;


    UIMessageGroup(String message) {
        this.message = message;
    }

    public String getMessage() {return message;}
}
