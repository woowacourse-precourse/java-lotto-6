package lotto.domain;

import java.util.ArrayList;
import java.util.List;

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
}
