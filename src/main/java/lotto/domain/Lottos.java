package lotto.domain;

import java.util.List;

public record Lottos(List<Lotto> lottos) {

    public int size() {
        return lottos.size();
    }

    public List<LottoRanking> calculateRankings(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::calculateRanking)
                .toList();
    }

    @Override
    public List<Lotto> lottos() {
        return List.copyOf(lottos);
    }
}
