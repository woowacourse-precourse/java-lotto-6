package lotto;

public class OutputUI {
    public static void outputBought(int bought) {
        System.out.println(bought + "개를 구매했습니다.");
    }

    public static void outputResultTitle() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void outputResult(Rank rank, int[] lottoWinsCount) {
        System.out.println(rank.getMessage() + lottoWinsCount[rank.ordinal()] + "개");
    }

    public static void outputProfit(double profit) {
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }
}
