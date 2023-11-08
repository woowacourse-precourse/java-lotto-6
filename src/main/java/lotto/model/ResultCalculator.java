package lotto.model;

import static lotto.Constraints.LOTTO_PRICE;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import lotto.model.enums.Rank;

public class ResultCalculator {
    WinLotto winLotto;
    Lottos lottos;

    public ResultCalculator(WinLotto winLotto, Lottos lottos) {
        this.winLotto = winLotto;
        this.lottos = lottos;
    }

    // 비교 결과를 Map으로 반환
    public Map<Rank, Integer> calculateResult() {
        List<Rank> ranks = calculateRanks();
        SortedMap<Rank, Integer> result = new TreeMap<>(Comparator.comparingInt(Rank::getPrizeMoney));
        ranks.forEach(rank -> result.merge(rank, 1, Integer::sum));
        return Collections.unmodifiableMap(result);
    }

    //수익률 계산
    public double calculateRateOfReturn() {
        List<Rank> ranks = calculateRanks();
        long totalReturn = ranks.stream()
                .mapToLong(Rank::getPrizeMoney)
                .sum();
        int amount = ranks.size() * LOTTO_PRICE.getValue();

        return Math.round(((double) totalReturn / amount * 10000)) / 100.0;
    }

    // 로또의 Rank를 List로 반환
    private List<Rank> calculateRanks() {
        return lottos.lottosInfo().stream()
                .map(this::calculateLottoRank)
                .toList();
    }

    // 로또의 Rank 계산
    private Rank calculateLottoRank(Lotto lotto) {
        int count = winLotto.winNumbers().calculateSameNumberCount(lotto);
        boolean isBonus = lotto.contains(winLotto.bonusNumber().number()) && Rank.isThirdCount(count);
        return Rank.calculateRank(count, isBonus);
    }
}
