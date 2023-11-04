package lotto.ui;

import lotto.domain.constant.LottoPrize;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PRINT_HISTORY = "당첨 통계\n---";
    private static final String DELIMITER = " - ";
    private static final String PRINT_COUNT = "개";
    private static final String PRINT_PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String PRINT_PROFIT_RATE = "총 수익률은 ";
    private static final String PRINT_PERCENT = "%입니다.";

    public void printPurchaseCount(int purchaseLottoCount) {
        System.out.println(purchaseLottoCount + PRINT_PURCHASE_COUNT);
    }

    public void printGenerateLottos(List<List<Integer>> lottos) {
        lottos.stream()
                .forEach(lotto -> System.out.println(lotto));
    }

    public void printLottoResults(Map<LottoPrize, Integer> lottoPrizesHistory) {
        System.out.println(PRINT_HISTORY);

        List<LottoPrize> lottoPrizes = lottoPrizesHistory.keySet().stream()
                .sorted(Comparator.comparing(LottoPrize::getPrizeMoney))
                .collect(Collectors.toList());

        lottoPrizes.stream().forEach(lottoPrize ->
                System.out.println(lottoPrize.toMessage() + DELIMITER
                        + lottoPrizesHistory.get(lottoPrize) + PRINT_COUNT));
    }


    public void printProfitRate(double profitRate) {
        System.out.println(PRINT_PROFIT_RATE + profitRate + PRINT_PERCENT);
    }

    public void printException(String errorMessage) {
        System.out.println(errorMessage);
    }
}
