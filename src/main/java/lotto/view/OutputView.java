package lotto.view;


import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;


import java.util.Map;

import static lotto.constant.DisplayMessages.*;

public class OutputView {

    public static void purchaseCount(int count) {
        System.out.println(PURCHASE_QUANTITY
                .format(count));
    }

    public static void displayLottoPapers(LottoMachine lottoMachine) {
        lottoMachine.getLottoPapers().forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }

    public static void displayResults(LottoResult lottoResult) {
        System.out.println(PRIZE_STATISTICS.getMessage());
        System.out.println(SEPARATOR.getMessage());
        Map<LottoRank, Integer> lottoPrizeResult = lottoResult.getLOTTO_RESULT();
        lottoPrizeResult.forEach((key, value) -> {
            checkSecondPrize(key, value);
            checkAnotherPrize(key, value);
            System.out.println();
        });
    }

    private static void checkSecondPrize(LottoRank key, Integer value) {
        if (key == LottoRank.SECOND_RANK) {
            System.out.printf(String.valueOf(MATCH_COUNT_BONUS.getMessage()),
                    key.getMatchCount(), key.getPrizeMoney(), value);
        }
    }

    private static void checkAnotherPrize(LottoRank key, Integer value) {
        if (key != LottoRank.SECOND_RANK && key != LottoRank.NO_RANK) {
            System.out.printf(String.valueOf(MATCH_COUNT.getMessage()),
                    key.getMatchCount(), key.getPrizeMoney(), value);

        }
    }

    public static void displayProfitMargin(double profitMargin) {
        System.out.println(TOTAL_RETURN.format(profitMargin));
    }
}