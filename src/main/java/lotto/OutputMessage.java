package lotto;

public enum OutputMessage {

    INSERT_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    BUY_LOTTO_MESSAGE("개를 구매했습니다."),
    INSERT_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INSERT_BONUS_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_STATISTIC_MESSAGE("당첨 통계"),
    DIVISION_MESSAGE("---"),
    SAME_3_NUMBER_MESSAGE("3개 일치 (5,000원) - "),
    SAME_4_NUMBER_MESSAGE("4개 일치 (50,000원) - "),
    SAME_5_NUMBER_MESSAGE("5개 일치 (1,500,000원) - "),
    SAME_5_AND_BONUS_BALL_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SAME_6_NUMBER_MESSAGE("6개 일치 (2,000,000,000원) - "),
    COUNT_MESSAGE("개"),
    RATE_OF_RETURN_MESSAGE("총 수익률은 "),
    FINISH_MESSAGE("%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }

    public void print() {
        System.out.println(this.message);
    }
}
