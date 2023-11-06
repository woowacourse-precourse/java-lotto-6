package lotto.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import lotto.domain.LottoOption;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.message.ViewMessage;

public class OutputView {

    private static NumberFormat format = new DecimalFormat("#,###.##");

    public static void printLottos(Lottos lottoPurchaseInfo) {
        System.out.println(lottoPurchaseInfo.getCount() + "개를 구매했습니다.");
        System.out.println(lottoPurchaseInfo.getLottosNumber());
    }

    public static void printException(IllegalArgumentException e) {
        System.out.println("[ERROR] : " + e.getMessage());
    }

    public static void printResult(WinningLotto answerLotto, Lottos lottoInfo) {
        printResultHeader();
        Map<Rank, Integer> rankIntegerMap = answerLotto.calculateResult(lottoInfo.getLottoItems());
        printByRank(Rank.FIFTH, rankIntegerMap.get(Rank.FIFTH));
        printByRank(Rank.FOURTH, rankIntegerMap.get(Rank.FOURTH));
        printByRank(Rank.THIRD, rankIntegerMap.get(Rank.THIRD));
        printByRank(Rank.SECOND, rankIntegerMap.get(Rank.SECOND));
        printByRank(Rank.FIRST, rankIntegerMap.get(Rank.FIRST));
        printProfitRate(rankIntegerMap, lottoInfo.getCount());
    }

    private static void printResultHeader() {
        System.out.println(ViewMessage.OUTPUT_RESULT_HEADER);
    }

    private static void printByRank(Rank rank, int count) {
        System.out.printf("%s - %d개\n", rank.getMessage(), count);
    }

    private static void printProfitRate( Map<Rank, Integer> rankIntegerMap, int count) {
        int purchaseCost = LottoOption.LOTTO_PRICE * count;
        int totalPrize = (int) rankIntegerMap.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        float profitRate = ((totalPrize * 1.0f) / purchaseCost) * 100;
        System.out.printf(ViewMessage.OUTPUT_PROFIT_RATE, format.format(profitRate));
    }
}
