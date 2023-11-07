package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.RankCounter;
import lotto.utils.Constants;
import lotto.utils.message.OutputMessage;
import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + OutputMessage.OUTPUT_PURCHASED_LOTTOS.getMessage());
        lottos.stream()
                .map(Lotto::getSortedNumbers)
                .forEach(System.out::println);
    }

    public static void printLottoResult(RankCounter lottoResult) {
        System.out.println(OutputMessage.OUTPUT_LOTTO_RESULT.getMessage());
        Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() >= Constants.MATCH_COUNT_THRESHOLD)
                .forEach(rank -> {
                    int count = lottoResult.getRankCount(rank);
                    System.out.println(rank.getMessage() + count + OutputMessage.OUTPUT_COUNT_UNIT.getMessage());
                });
    }

    public static void printYield(double yield) {
        System.out.println(OutputMessage.getYieldMessage(yield));
    }
}
