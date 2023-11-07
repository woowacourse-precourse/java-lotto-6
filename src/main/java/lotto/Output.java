package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Output {
    public static void message(String message) {
        System.out.println(message);
    }

    public static void issueLotto(int issueCount, List<Lotto> lottos) {
        final String purchaseMessage = "\n" + issueCount + "개를 구매했습니다.";
        message(purchaseMessage);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void winStatistics(Map<Rank, Integer> lottoResult) {
        final String winStatisticsMessage = "\n당첨 통계\n---";
        message(winStatisticsMessage);

        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            int totalCount = lottoResult.get(rank);
            String message = rank.getOutputMessage() + totalCount + "개";
            System.out.println(message);
        }
    }

    public static void returnRate(double returnRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        String formattedReturnRate = decimalFormat.format(returnRate);

        String message = "총 수익률은 " + formattedReturnRate + "%입니다.";
        System.out.println(message);
    }
}
