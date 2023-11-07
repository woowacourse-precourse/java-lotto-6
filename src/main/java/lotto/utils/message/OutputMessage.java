package lotto.utils.message;

public enum OutputMessage {

    OUTPUT_COUNT_UNIT("개"),
    OUTPUT_PURCHASED_LOTTOS("개를 구매했습니다.\n"),
    OUTPUT_LOTTO_RESULT("\n당첨 통계\n---"),
    OUTPUT_YIELD("총 수익률은 ");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getYieldMessage(double yield) {
        return OUTPUT_YIELD.message + String.format("%.1f", yield) +"%입니다.";
    }
}
