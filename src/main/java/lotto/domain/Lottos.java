package lotto.domain;

import java.util.List;

public record Lottos(List<Lotto> lottos) {

    public int size() {
        return lottos.size();
    }

    public Lottos {
        validateLottoSize(lottos);
    }

    private void validateLottoSize(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("[Error] 로또 리스트는 비어있을 수 없습니다.");
        }
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
