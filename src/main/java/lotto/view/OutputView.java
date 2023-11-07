package lotto.view;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoResult;
import lotto.domain.rank.Rank;
import lotto.dto.Result;

public class OutputView {

    private static final String NEWLINE = "\n";
    private static final String PURCHASE_QUANTITY_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_RESULT_MESSAGE = "\n당첨 통계\n---\n";
    private static final String MATCH_COUNT_MESSAGE = "개 일치";
    private static final String BONUS_NUMBER_MESSAGE = ", 보너스 볼 일치";
    private static final String REWARD_AND_COUNT_MESSAGE = " (%s원) - %d개\n";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");
    private static final String REVENUE_MESSAGE = "총 수익률은 %.1f%%입니다.";


    public void printPurchasedLottos(final List<Lotto> purchasedLottos) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(PURCHASE_QUANTITY_MESSAGE, purchasedLottos.size()));
        purchasedLottos.forEach(purchasedLotto -> appendPurchasedLotto(purchasedLotto, stringBuilder));
        System.out.println(stringBuilder);
    }

    private void appendPurchasedLotto(Lotto purchasedLotto, StringBuilder stringBuilder) {
        stringBuilder.append(purchasedLotto.numbers());
        stringBuilder.append(NEWLINE);
    }

    public void printWinningResult(final Result winningResult) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(WINNING_RESULT_MESSAGE);
        appendStatistics(winningResult, stringBuilder);
        appendRevenue(winningResult, stringBuilder);
        System.out.println(stringBuilder);
    }

    private void appendStatistics(final Result winningResult, final StringBuilder stringBuilder) {
        final EnumMap<Rank, Integer> rankResult = winningResult.rankResult();
        rankResult.keySet()
                .stream()
                .sorted()
                .forEach(rank -> appendRankResult(rank, rankResult.get(rank), stringBuilder));
    }

    private void appendRankResult(final Rank rank, final int count, final StringBuilder stringBuilder) {
        final LottoResult lottoResult = rank.lottoResult();
        stringBuilder.append(lottoResult.matchCount());
        stringBuilder.append(MATCH_COUNT_MESSAGE);
        if (lottoResult.hasBonusNumber()) {
            stringBuilder.append(BONUS_NUMBER_MESSAGE);
        }
        stringBuilder.append(String.format(REWARD_AND_COUNT_MESSAGE, DECIMAL_FORMAT.format(rank.reward()), count));
    }

    private void appendRevenue(final Result winningResult, final StringBuilder stringBuilder) {
        stringBuilder.append(String.format(REVENUE_MESSAGE, winningResult.revenue()));
    }
}
