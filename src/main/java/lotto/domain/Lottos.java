package lotto.domain;

import java.util.List;
import lotto.dto.WinningResultResponse;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos.stream().toList();
    }

    public List<Lotto> getLottos() {
        return lottos.stream().toList();
    }

    public WinningResultResponse generateWinningResult(WinningLotto winningLotto) {
        WinningResultResponse compareResult = new WinningResultResponse();

        lottos.forEach(lotto -> compareResult.increaseMatchingCount(winningLotto.getPrize(lotto)));
        return compareResult;
    }
}