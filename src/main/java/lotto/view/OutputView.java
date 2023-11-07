package lotto.view;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    public void purchasePieces(int pieces) {
        System.out.println("\n" + pieces + "개를 구매했습니다.");
    }

    public void purchaseNum(List<Integer> lottoNum) {
        System.out.println(lottoNum);
    }

    public void errorMessage(String e) {
        System.out.println(e);
    }

    public void statistics(HashMap<Integer, Integer> result) {
        System.out.println("\n당첨통계\n---");
        printPrizeCount("3개 일치 (5,000원)", result.get(3));
        printPrizeCount("4개 일치 (50,000원)", result.get(4));
        printPrizeCount("5개 일치 (1,500,000원)", result.get(5));
        printPrizeCount("5개 일치, 보너스 볼 일치 (30,000,000원)", result.get(6));
        printPrizeCount("6개 일치 (2,000,000,000원)", result.get(7));
    }

    public void profit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }

    private void printPrizeCount(String prize, int count) {
        System.out.println(prize + " - " + count + "개");
    }
}