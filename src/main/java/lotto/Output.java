package lotto;

import java.util.List;

public class Output {
    public static void message(String message) {
        System.out.println(message);
    }

    public static void issueLotto(int lottoCount, List<Lotto> lottos) {
        final String purchaseMessage = "개를 구매했습니다.";
        message(Integer.toString(lottoCount).concat(purchaseMessage));

        for (Lotto lotto : lottos) {
            lotto.getNumbers().toString();
        }
    }

    public static void winStatistics(List<Integer> winRanks) {
        final String winStatisticsMessage = "당첨 통계\n---";
        message(winStatisticsMessage);
        // continue...
    }

    public static void returnRate(double returnRate) {
        System.out.println(Math.round(returnRate));
    }

}
