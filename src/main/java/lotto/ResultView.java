package lotto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class ResultView {
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
    public static void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        LottoRank[] ranks = LottoRank.values();
        Arrays.sort(ranks, Comparator.comparingInt(LottoRank::getMatchCount));

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        printStatistics(ranks, numberFormat, result);
        printEarningsRate(result, purchaseAmount);
    }

    private static void printStatistics(LottoRank[] ranks, NumberFormat numberFormat, LottoResult result) {
        for (LottoRank rank : ranks) {
            if (rank == LottoRank.MISS) continue;
            System.out.println(getMatchMessage(rank, numberFormat, result));
        }
    }

    private static String getMatchMessage(LottoRank rank, NumberFormat numberFormat, LottoResult result) {
        String matchMessage = rank.getMatchCount() + "개 일치";

        if (rank == LottoRank.SECOND) {
            matchMessage += ", 보너스 볼 일치";
        }

        String winningsFormatted = numberFormat.format(rank.getWinnings()) + "원";
        matchMessage += " (" + winningsFormatted + ") - " + result.getCount(rank) + "개";

        return matchMessage;
    }

    private static void printEarningsRate(LottoResult result, int purchaseAmount) {
        double earningsRate = result.calculateEarningsRate(purchaseAmount) * 100;
        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println("총 수익률은 " + df.format(earningsRate) + "%입니다.");
    }
}

