package lotto.view;

import static lotto.view.PromptMessage.PURCHASE_NUMBERS_OF_LOTTO;

import java.text.NumberFormat;
import java.util.Arrays;
import lotto.domain.Lottos;
import lotto.domain.RankPrize;
import lotto.domain.RankResult;

public class OutputView {

    public void promptMessage(String message) {
        System.out.println(message);
    }

    public void purchasedNumberOfLotto(int number) {
        System.out.println(String.format(PURCHASE_NUMBERS_OF_LOTTO.getMessage(), number));
    }

    public void printPurchasedLottoNumbers(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printRankResult(RankResult rankResult) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        Arrays.stream(RankPrize.values())
                .forEach(rankPrize -> System.out.println(
                        String.format(rankPrize.getRankMessage(),
                                rankPrize.getMatchCounts(),
                                numberFormat.format(rankPrize.getPrizeAmount()),
                                rankResult.getWinCounts(rankPrize))));
    }

    public void printTotalReturn(double totalReturn) {
        System.out.println(String.format("%.1f", totalReturn));
    }
}
