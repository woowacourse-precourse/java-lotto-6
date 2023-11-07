package lotto.domain;


import static lotto.domain.constants.LottoConfig.LOTTO_COUNT;
import static lotto.domain.constants.LottoConfig.LOTTO_UNIT_PRICE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.constants.LottoStatisticsContent;

public class LottoStatistics {
    private final List<LottoStatisticsContent> lottoResult = new ArrayList<>();
    private int totalPrize = 0;
    private LottoStatistics(Lottos lottoTicket, Lotto winningLotto, Bonus bonus) {
        List<Integer> winningNumber = winningLotto.getNumbers();
        Integer bonusNumber = bonus.getBonusNumber();

        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            long count = lotto.getNumbers().stream()
                    .filter(winningNumber::contains)
                    .count();
            LottoStatisticsContent.matchHitCount(count).increasePrizeCount();
            totalPrize += LottoStatisticsContent.matchHitCount(count).getPrize();
        }
        lottoResult.addAll(Arrays.asList(LottoStatisticsContent.values()));
    }

    public static LottoStatistics from(Lottos lottoTicket, Lotto winningLotto, Bonus bonus) {
        return new LottoStatistics((lottoTicket), winningLotto, bonus);
    }

    public String generateLottoStatisticsForm() {
        Collections.reverse(lottoResult);
        lottoResult.remove(0);
        String prefix = "당첨 통계\n---\n";
        String statistics =  lottoResult.stream()
                .map(e -> String.format(
                        "%s%d개", e.getMessage(), e.getPrizeCount())
                )
                .collect(Collectors.joining("\n"));
        String profitRate = String.format(
                "총 수익률은 %f입니다.\n", ((double) totalPrize / LOTTO_COUNT.getValue() * LOTTO_UNIT_PRICE.getValue())
        );
        return String.format(
                "%s%s%s",
                prefix, statistics, profitRate
        );
    }
}
