package lotto;

public enum CommonMessages {

    // Input Messages
    PURCHASE_AMOUNT_INPUT("구입금액을 입력해 주세요."),
    WINNING_AMOUNT_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),

    // Result Messages
    WINNING_RESULT("당첨 통계\n" + "---"),
    MATCH_THREE("3개 일치 (5,000)원 - "),
    MATCH_FOUR("4개 일치 (50,000)원 - "),
    MATCH_FIVE("5개 일치 (1,500,000)원 - "),
    MATCH_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000)원 - "),
    MATCH_SIX("6개 일치 (2,000,000,000)원 - "),
    PROFIT_RATE("총 수익률은 ");

    private final String message;

    CommonMessages(String message) {

        this.message = message;
    }

    public String getMessage() {

        return this.message;
    }

    public String getMessage(Integer count) {

        return this.message + count + "개";
    }

    public String getMessage(double profit) {

        return this.message + profit + "%입니다.";
    }
}
