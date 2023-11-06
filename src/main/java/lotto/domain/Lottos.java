package lotto.domain;

import lotto.domain.constants.LottoRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int lottoCount() {
        return this.lottos.size();
    }

    public Map<LottoRank, Integer> winningLottoCompareLottos(WinningLotto winningLotto) {
        Map<LottoRank, Integer> result = setLottoRankResult();
        this.lottos.stream()
                .map(winningLotto::lottoResult)
                .forEach(rank -> result.put(rank, result.getOrDefault(rank, 0) + 1));
        return result;
    }

    public Map<LottoRank, Integer> setLottoRankResult() {
        Map<LottoRank, Integer> result = new HashMap<>();
        Arrays.stream(LottoRank.values())
                .forEach(rank -> result.put(rank, 0));
        return result;
    }
}