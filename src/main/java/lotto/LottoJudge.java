package lotto;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.dto.LottoResult;
import lotto.exception.lottojudge.JudgeNotConfiguredException;

public class LottoJudge {
    private WinningLotto winningLotto;

    public void configure(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    private void validateConfiguration() {
        if (!isConfigured()) {
            throw new JudgeNotConfiguredException();
        }
    }

    private boolean isConfigured() {
        return winningLotto != null;
    }

    public LottoResult judge(LottoBundle lottoBundle) {
        validateConfiguration();

        Map<LottoRank, Long> rankMap = lottoBundle.getLottos().stream()
                .collect(Collectors.groupingBy(
                        lotto -> LottoRank.judge(lotto, winningLotto),
                        () -> new EnumMap<>(LottoRank.class),
                        Collectors.counting()
                ));

        double profitRate = calculateProfitRate(rankMap, lottoBundle.getLottos().size());

        return LottoResult.from(rankMap, profitRate);
    }

    private double calculateProfitRate(Map<LottoRank, Long> rankMap, int size) {
        int sum = 0;

        for (Map.Entry<LottoRank, Long> entry : rankMap.entrySet()) {
            LottoRank lottoRank = entry.getKey();
            Long count = entry.getValue();
            double prize = lottoRank.getPrize().getValue();
            double profit = prize * count;
            sum += profit;
        }

        return sum / (double) (size * LottoSeller.LOTTO_PRICE);
    }
}
