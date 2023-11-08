package lotto.view;

public class OutputView {
    public static final String LOTTO_COUNT = "개를 구매했습니다.";
    public static final String WINNING_STATICS = "당첨 통계";
    public static final String CUT_LINE = "---";

    public static void printLottoCount(int count) {
        System.out.println(count + LOTTO_COUNT);
    }

    public static void printWinningStatics() {
        System.out.println(WINNING_STATICS);
        System.out.println(CUT_LINE);
    }

    public static void printSuccessResult(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }
    public static void printRateOfReturn(double earningRate){
        System.out.println("총 수익률은 "+String.format("%.1f", earningRate)+ "%입니다.");
    }
}
