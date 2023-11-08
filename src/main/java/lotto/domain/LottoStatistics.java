package lotto.domain;


import static lotto.domain.constants.LottoConfig.LOTTO_UNIT_PRICE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.constants.LottoStatisticsContent;

public class LottoStatistics {
    private final List<LottoStatisticsContent> lottoResult = new ArrayList<>();
    private final int purchaseCount;
    private int totalPrize = 0;

    private LottoStatistics(Lottos lottoTicket, Lotto winningLotto, Bonus bonus, Buyer buyer) {
        List<Integer> winningNumber = winningLotto.getNumbers();
        Integer bonusNumber = bonus.getBonusNumber();
        purchaseCount = buyer.getPurchaseCount();

        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            long count = lotto.getNumbers().stream()
                    .filter(winningNumber::contains)
                    .count();
            LottoStatisticsContent.matchHitCount(count).increasePrizeCount();
            totalPrize += LottoStatisticsContent.matchHitCount(count).getPrize();
        }
        lottoResult.addAll(Arrays.asList(LottoStatisticsContent.values()));
    }

    public static LottoStatistics from(Lottos lottoTicket, Lotto winningLotto, Bonus bonus, Buyer buyer) {
        return new LottoStatistics((lottoTicket), winningLotto, bonus, buyer);
    }

    public String generateLottoStatisticsForm() {
        Collections.reverse(lottoResult);
        lottoResult.remove(0);
        String prefix = "당첨 통계\n---\n";
        String statistics = lottoResult.stream()
                .map(e -> String.format(
                        "%s%d개", e.getMessage(), e.getPrizeCount())
                )
                .collect(Collectors.joining("\n"));

        String profitRate = String.format(
                "\n총 수익률은 %.1f%%입니다.\n",
                ((double) totalPrize / (this.purchaseCount * LOTTO_UNIT_PRICE.getValue()) * 100)
        );
        return String.format(
                "%s%s%s",
                prefix, statistics, profitRate
        );
    }
}
