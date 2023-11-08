package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningResult;

public final class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<WinningResult> getWinningResults(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(winningNumbers::getWinningResult)
                .toList();
    }

    public List<List<Integer>> getSortedLottos() {
        return lottos.stream()
                .map(Lotto::getSortedNumbers)
                .toList();
    }
}
