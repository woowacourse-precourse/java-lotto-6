package lotto.View;

public class OutputView {
    public static final String OUTPUT_LOTTO_PURCHASED = "개를 구매했습니다.";
    public static final String OUTPUT_WIN_RESULT = "당첨 통계\n---";

    public static void OutputLottoPurchased(int count) {
        System.out.println(count + OUTPUT_LOTTO_PURCHASED);
    }

    public static void OutputWinResult() {
        System.out.println(OUTPUT_WIN_RESULT);
    }

    public static void OutputNumberOfMatch(String message, int numberOfMatch) {
        System.out.println(message + " - " + numberOfMatch + "개");
    }

    public static void OutputProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}
