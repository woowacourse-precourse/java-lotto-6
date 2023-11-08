package lotto;

import java.text.DecimalFormat;

public class OutputView {

    public static void printTitle(){
        System.out.println("당첨통계");
        System.out.println("---");
    }

    public static void printResult(WinningCondition winningCondition, int count) {

        System.out.printf("%d개 일치", winningCondition.getMatchCount());
        if (winningCondition.isContainBonusNumber()) {
            System.out.print(", 보너스 볼 일치");
        }

        int winningAmount = winningCondition.getWinningAmount();
        DecimalFormat moneyFormat = new DecimalFormat("###,###");
        System.out.printf(" (%s원)", moneyFormat.format(winningAmount));

        System.out.printf(" - %d개", count);
        System.out.println();



    }

    public static void printProfitRate(float profitRate){
        // 오류?
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }


}
