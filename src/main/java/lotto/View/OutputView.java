package lotto.View;

public class OutputView {

    public static int getLottoCount(int amount) {
        System.out.println();
        int LottoCount = amount / 1000;
        System.out.println(LottoCount + "개를 구매했습니다.");
        return LottoCount;
    }

    public static void printResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printRevenueRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }

    public static void printSuccessMessage(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }
}
