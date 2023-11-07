package lotto.domain;

import java.util.List;

public record Lottos(List<Lotto> lottos) {

    public int size() {
        return lottos.size();
    }

    public LottoRankings calculateRankings(WinningLotto winningLotto) {
        List<LottoRanking> rankings = lottos.stream()
                .map(winningLotto::calculateRanking)
                .toList();

        return new LottoRankings(rankings);
    }

    @Override
    public List<Lotto> lottos() {
        return List.copyOf(lottos);
    }
}
