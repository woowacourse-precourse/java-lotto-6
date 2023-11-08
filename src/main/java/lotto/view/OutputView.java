package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    public static void printPurchaseAmountMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCntMessage(int lottoCnt){
        System.out.println(lottoCnt + "개를 구매했습니다.");
    }

    public static void printLottosMessage(List<Lotto> lottos){
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers());
        }
    }

    public static void printWinningNumbersMessage(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberMessage(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printGameResultMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printWinningStatisticsMessage(List<Integer> winningStatistics){
        for (int i = 0; i < winningStatistics.size(); i++) {
            printWinningStatisticsCaseMessage(i, winningStatistics.get(i));
        }
    }

    public static void printWinningStatisticsCaseMessage(Integer index, Integer value){
        if (index == 0){
            System.out.println("3개 일치 (5,000원) - " + value + "개");
        } else if (index == 1){
            System.out.println("4개 일치 (50,000원) - " + value + "개");
        } else if (index == 2){
            System.out.println("5개 일치 (1,500,000원) - " + value + "개");
        } else if (index == 3){
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + value + "개");
        } else if (index == 4){
            System.out.println("6개 일치 (2,000,000,000원) - " + value + "개");
        }
    }

    public static void printRateOfReturnMessage(String rateOfReturn){
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
