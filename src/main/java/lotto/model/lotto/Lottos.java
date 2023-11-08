package lotto.model.lotto;

import java.util.List;
import lotto.model.calculate.WinningResult;
import lotto.model.dto.LottoPaper;
import lotto.model.lottoPick.PickedLotto;

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

    public WinningResult createWinningResult(PickedLotto pickedLotto) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottos) {
            lotto.calculateLottoPlace(pickedLotto)
                    .ifPresent(winningResult::plusLottoPlace);
        }
        return winningResult;
    }
}

