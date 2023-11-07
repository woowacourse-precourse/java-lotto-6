package lotto.model;

import java.util.List;

public class WinningLottos {
    private final List<WinningLotto> winningLottos;

    public WinningLottos(List<WinningLotto> winningLottos) {
        this.winningLottos = winningLottos;
    }

    public int getTotalAmounts() {
        return winningLottos.stream()
                .mapToInt(WinningLotto::getAmounts)
                .sum();
    }

    public long getWinningLottoCount(WinningLotto winningLotto) {
        return winningLottos.stream()
                .filter(lotto -> lotto == winningLotto)
                .count();
    }
}
