package lotto.model;

import static lotto.Constraints.LOTTO_PRICE;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import lotto.model.enums.Rank;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    // 비교 결과를 Map으로 반환
    public Map<Rank, Integer> calculateResult(WinLotto winLotto) {
        List<Rank> ranks = calculateRanks(winLotto);
        SortedMap<Rank, Integer> result = new TreeMap<>(Comparator.comparingInt(Rank::getPrizeMoney));
        ranks.forEach(rank -> result.merge(rank, 1, Integer::sum));
        return Collections.unmodifiableMap(result);
    }

    //수익률 계산
    public double calculateRateOfReturn(WinLotto winLotto) {
        List<Rank> ranks = calculateRanks(winLotto);
        long totalReturn = ranks.stream()
                .mapToLong(Rank::getPrizeMoney)
                .sum();
        int amount = ranks.size() * LOTTO_PRICE.getValue();

        return Math.round(((double) totalReturn / amount * 10000)) / 100.0;
    }

    // 당첨로또번호와 로또번호들 비교
    private List<Rank> calculateRanks(WinLotto winLotto) {
        return lottos.stream()
                .map(winLotto::calculateLottoRank)
                .toList();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}