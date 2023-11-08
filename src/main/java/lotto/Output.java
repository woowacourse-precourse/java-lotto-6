package lotto;

import lotto.enums.LottoPrize;

import java.text.DecimalFormat;
import java.util.List;
import java.util.TreeMap;

public class Output {
    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(List<List<Integer>> lottos) {
        System.out.println(lottoToString(lottos));
    }

    public static void printLottoResult(TreeMap<LottoPrize, Integer> winningCount) {
        System.out.println(getLottoResult(winningCount));
    }

    public static void printProfit(DecimalFormat decimalFormat, double profit) {
        System.out.println("총 수익률은 " + decimalFormat.format(profit) + "%입니다.");
    }

    private static String lottoToString(List<List<Integer>> lottos) {
        StringBuilder ret = new StringBuilder();
        lottos.forEach(i -> {
            ret.append(i.toString());
            ret.append("\n");
        });
        return ret.toString().trim();
    }

    private static String getLottoResult(TreeMap<LottoPrize, Integer> winningCount) {
        StringBuilder ret = new StringBuilder();
        ret.append("당첨 통계\n").append("---\n");
        for (LottoPrize lottoPrize: LottoPrize.values()) {
            int count = winningCount.getOrDefault(lottoPrize, 0);
            buildLottoResult(ret, lottoPrize, count);
        }
        return ret.toString().trim();
    }


    private static void buildLottoResult(StringBuilder ret, LottoPrize lottoPrize, int count) {
        int matchingNumbers = lottoPrize.getMatchingNumbers();
        long prizeMoney = lottoPrize.getPrizeMoney();
        if (prizeMoney != 0) {
            ret.append(matchingNumbers).append("개 일치");
            if (lottoPrize == LottoPrize.MATCH_5_BONUS) {
                ret.append(", 보너스 볼 일치");
            }
            ret.append(" (").append(String.format("%,d", prizeMoney)).append("원)")
                    .append(" - ").append(count).append("개")
                    .append("\n");
        }
    }
}
