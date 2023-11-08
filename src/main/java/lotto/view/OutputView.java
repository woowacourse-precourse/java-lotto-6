package lotto.view;

import java.util.Map;

public class OutputView {

    public static void printPurchaseQuantity(int number) {
        System.out.printf("%d개를 구매했습니다.\n", number);
    }

    public static void printMatchResult(int countOfMatch, int winningMoney, int countOfSameRank) {
        String str = String.format("%,d", winningMoney);
        System.out.println(countOfMatch + "개 일치 (" + str + "원) - " + countOfSameRank + "개");
    }

    public static void printMatchResultBonus(int countOfMatch, int winningMoney, int countOfSameRank) {
        String str = String.format("%,d", winningMoney);
        System.out.println(
                countOfMatch + "개 일치, 보너스 볼 일치 (" + str + "원) - " + countOfSameRank + "개");
    }

    public static void printRevenue(float revenue) {
        System.out.println("총 수익률은 " + String.format("%.1f", revenue) + "%입니다.");
    }

}
