package lotto.view;

public class ResultView {
    private static final String BUY_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WIN_RESULT_MESSAGE = "당첨 통계";
    private static final String WIN_RESULT_MESSAGE_SPLITTER = "---";
    private static final String[] RESULTS = {"3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)", "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"};
    private static final String RETURN_RATE_MESSAGE = "총 수익률은 ";

    public static void printBuyAmount(int amount) {
        System.out.println(amount + BUY_AMOUNT_MESSAGE);
    }

    public static void printWinResult() {
        System.out.println(WIN_RESULT_MESSAGE);
        System.out.println(WIN_RESULT_MESSAGE_SPLITTER);
    }

    public static void showResult(int[] matchCounts) {
        String[] results = RESULTS;
        for (int i = 0; i < matchCounts.length; i++) {
            System.out.println(results[i] + " - " + matchCounts[1] + "개");
        }
    }

    public static void showRateOfReturn(double returnRate) {
        System.out.println(RETURN_RATE_MESSAGE + returnRate + "%입니다.");
    }
}
