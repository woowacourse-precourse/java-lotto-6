package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class MessageResolver {
    private static final String PURCHASE_AMOUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.\n";
    private static final String PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String NON_BONUS_RANK_DESCRIPTION = "%d개 일치 (%,d원) - %d개";
    private static final String BONUS_RANK_DESCRIPTION = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String RESULT_MESSAGE_PREFIX = "\n당첨 통계\n---\n";

    public String resolvePurchasedInformationMessage(List<Lotto> lottos) {
        return String.format(PURCHASE_AMOUNT_MESSAGE_FORMAT, lottos.size()) + lottos.stream()
                .map(lotto -> lotto.mapToSortedIntegers().toString())
                .collect(Collectors.joining("\n"));
    }

    public String resolveResultMessage(LottoResult result) {
        return RESULT_MESSAGE_PREFIX + Arrays.stream(LottoRank.values())
                .filter(rank -> !rank.equals(LottoRank.NONE))
                .map(rank -> resolveResultDescriptionMessage(rank, result.getCountByRank(rank)))
                .collect(Collectors.joining("\n"));
    }

    public String resolveResultDescriptionMessage(LottoRank rank, int winCount) {
        if (rank.isBonusMustMatch()) {
            return String.format(BONUS_RANK_DESCRIPTION, rank.getMatchingCount(), rank.getPrize(), winCount);
        }
        return String.format(NON_BONUS_RANK_DESCRIPTION, rank.getMatchingCount(), rank.getPrize(), winCount);
    }

    public String resolveProfitRateMessage(double profitRate) {
        return String.format(PROFIT_RATE_MESSAGE_FORMAT, profitRate);
    }
}
