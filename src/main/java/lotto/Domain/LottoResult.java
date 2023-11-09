package lotto.Domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.Util.LottoComparator;

public class LottoResult {
    private final LottoComparator lottoComparator;
    private Map<LottoReward, Integer> resultStatistic;

    public LottoResult(Lotto winLotto) {
        lottoComparator = new LottoComparator(winLotto);
        resultStatistic = new HashMap<>();
        Arrays.stream(LottoReward.values()).forEach(lottoReward -> resultStatistic.put(lottoReward, 0));
    }

    public Map<LottoReward, Integer> createStatistic(TotalLotto totalLotto, LottoNumber bonusNumber) {
        for (Lotto lotto : totalLotto.getTotalLotto()) {
            int count = lottoComparator.compareLotto(lotto);
            boolean equalBonusNumber = lottoComparator.compareBonusNumber(lotto, bonusNumber);

            LottoReward lottoReward = LottoReward.getLottoReward(count, equalBonusNumber);
            resultStatistic.put(lottoReward, resultStatistic.getOrDefault(lottoReward, 0) + 1);
        }

        return resultStatistic;
    }

    public String calculateSumOfReward(Money money) {
        double beforeMoney = money.getValue();
        long sum = 0;
        for (LottoReward lottoReward : LottoReward.values()) {
            sum += lottoReward.getReward() * resultStatistic.getOrDefault(lottoReward, 0);
        }
        return String.format("%.1f", sum / beforeMoney * 100);
    }

}
