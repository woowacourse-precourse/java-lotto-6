package lotto.view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

public class OutputView {
    private static final String LOTTO_COUNT = "개를 구매했습니다.";
    private static final String PROFITRATE = "총 수익률은 %.1f%%입니다.";
    private static final String DECIMALFORMAT = "#,###원";
    private static final String ONLY_SECOND = "개 일치, 보너스 볼 일치 (";
    private static final String OTHER_PRIZE = "개 일치 (";
    private static final String COUNT = "개";


    private static final String PRINT_FORMAT =") - ";

    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + LOTTO_COUNT);
    }

    public static void printLottos(List<Lotto> lottos) {
      for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
        System.out.println();
    }

    public static void printLottoResult(EnumMap<LottoPrize, Integer> prizeCounts, int totalCost) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMALFORMAT);
        double sum = 0;
        for (LottoPrize prize : LottoPrize.values()) {
            int prizeMoney = prize.getPrizeMoney();
            String formattedPrizeMoney = decimalFormat.format(prizeMoney);
            int count = prizeCounts.getOrDefault(prize, 0);
            if (prize != LottoPrize.NOTHING && prize == LottoPrize.SECOND) {
                sum += count * prizeMoney;
                System.out.println(prize.getMatchedCount() + ONLY_SECOND + formattedPrizeMoney + PRINT_FORMAT + count + COUNT);
            }
            if (prize != LottoPrize.NOTHING) {
                sum += count * prizeMoney;
                System.out.println(prize.getMatchedCount() + OTHER_PRIZE + formattedPrizeMoney + PRINT_FORMAT + count + COUNT);
            }
        }
        double profitRate = (sum / totalCost) * 100;
        System.out.println(String.format(PROFITRATE, profitRate));
    }

    public static void printException(Exception e){
        System.out.println(e.getMessage());
    }
}
