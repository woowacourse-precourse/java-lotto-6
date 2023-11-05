package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.utils.Constants;
import lotto.utils.message.OutputMessage;
import java.util.HashMap;
import java.util.List;

public class OutputView {

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + OutputMessage.OUTPUT_PURCHASED_LOTTOS.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumbers());
        }
    }

    public static void printLottoResult(HashMap<Rank, Integer> lottoResult) {
        System.out.println(OutputMessage.OUTPUT_LOTTO_RESULT.getMessage());
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() >= Constants.MATCH_COUNT_THRESHOLD) {
                System.out.println(rank.getMessage() + lottoResult.get(rank) +
                        OutputMessage.OUTPUT_COUNT_UNIT.getMessage());
            }
        }
    }

    public static void printYield(double yield) {
        System.out.println(OutputMessage.getYieldMessage(yield));
    }
}
