package lotto;

import java.util.List;
import java.util.Map;

public class Output {
    public static void message(String message) {
        System.out.println(message);
    }

    public static void issueLotto(int lottoCount, List<Lotto> lottos) {
        final String purchaseMessage = "개를 구매했습니다.";
        message(Integer.toString(lottoCount).concat(purchaseMessage));

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void winStatistics(Map<Rank, Integer> lottoResult) {
        final String winStatisticsMessage = "당첨 통계\n---";
        message(winStatisticsMessage);

        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            String message = rank.getOutputMessage();
            int totalCount = lottoResult.get(rank);

            message.concat(Integer.toString(totalCount)).concat("개");

            System.out.println(message);
        }
    }

    public static void returnRate(double returnRate) {
        System.out.println(Math.round(returnRate));
    }

}
