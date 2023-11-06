package lotto.views;

import java.util.List;

public class OutputViews {
    static final String NUM_OF_PURCHASE_LOTTO = "개를 구매했습니다.";

    public static void endOfSection() {
        System.out.println();
    }

    public static void numOfPurchaseLotto(int purchaseNum) {
        System.out.println(purchaseNum + NUM_OF_PURCHASE_LOTTO);
    }

    public static void listOfPurchaseLotto(List<List<Integer>> allLotto) {
        for (List<Integer> lotto : allLotto) {
            System.out.println(lotto);
        }
    }

    public static void wrtieResultStatistic(String mess, int numOfMatches) {
        System.out.println(mess + numOfMatches);
    }
}
