package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.NumberOfRanks;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.ViewMessage.*;

public class OutputView {

    public static void showDrawnLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage());
        lottos.stream().map(Lotto::getSortedNumbers).forEach(System.out::println);
    }

    public static void showWinningResult(NumberOfRanks ranks) {
        System.out.println(WINNING_STATISTICS_MESSAGE.getMessage());
        Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() >= 3)
                .forEach(rank -> {int count = ranks.getRankCount(rank);
            System.out.println(rank.getMessage() + count + COUNT_MESSAGE.getMessage());
        });
    }

    public static void showTotalReturn(double totalReturn) {
        System.out.println(TOTAL_RETURN_MESSAGE.getMessage() + String.format("%.1f", totalReturn) + "%입니다.");
    }
}
