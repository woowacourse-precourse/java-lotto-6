package lotto.views;

import java.util.ArrayList;
import java.util.List;

public class OutputViews {
    static final String NUM_OF_PURCHASE_LOTTO = "개를 구매했습니다.";
    static final String WINN_STAT = "당첨 통계";

    public static void endOfSection() {
        System.out.println();
    }

    public static void numOfPurchaseLotto(int purchaseNum) {
        System.out.println(purchaseNum + NUM_OF_PURCHASE_LOTTO);
    }

    public static void listOfPurchaseLotto(List<List<Integer>> allLotto) {
        for (List<Integer> lotto : allLotto) {
            List<Integer> lottoSorted = new ArrayList<>(lotto);
            lottoSorted.sort(null);
            System.out.println(lottoSorted);
        }
    }

    public static void startWriteStat() {
        System.out.println(WINN_STAT);
        System.out.println("---");
    }

    public static void wrtieResultStatistic(String mess, int matchNum) {
        System.out.println(mess + matchNum + "개");
    }

    public static void wrtieResultRate(double per) {
        System.out.printf("총 수익률은 %.1f%%입니다.", per);
    }
}
