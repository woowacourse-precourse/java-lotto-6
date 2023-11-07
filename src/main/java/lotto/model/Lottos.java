package lotto.model;

import java.util.List;
import lotto.model.dto.LottoPaper;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoPaper> createLottoPapers() {
        return this.lottos
                .stream()
                .map(Lotto::getSortedNumbers)
                .map(LottoPaper::new)
                .toList();
    }

    public WinningResult createWinningResult(WinnigLotto winnigLotto) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottos) {
            lotto.calculateLottoPlace(winnigLotto)
                    .ifPresent(winningResult::plusLottoPlace);
        }
        return winningResult;
    }
}

