package lotto.constant;

public enum OutputConstant {

    PURCHASE_MESSAGE("개를 구매했습니다."),
    STATISTIC_MESSAGE("당첨 통계"),
    PROFITABILITY_MESSAGE("총 수익률은 "),
    NEW_LINE("\n"),
    SPLIT_LINE("---"),
    PER("개"),
    PERCENT("%입니다."),
    PROFITABILITY_FORMAT("%.1f");

    private final String message;

    OutputConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
