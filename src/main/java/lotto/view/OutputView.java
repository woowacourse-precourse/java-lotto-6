package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_BUY_LOTTO = "%d개를 구매했습니다.";

    public void printNumberOfBuyLotto(int numberOfLottoBuy) {
        System.out.println("");
        System.out.printf(NUMBER_OF_BUY_LOTTO, numberOfLottoBuy);
    }

    public void printLottoNums(List<Lotto> lottos) {
        System.out.println("");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println("");
    }

    public void printWinnerStatistcs(int[] prizeNumCount, double rateOfReturn) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prizeNumCount[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeNumCount[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeNumCount[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeNumCount[7] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeNumCount[6] + "개");
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }


}
