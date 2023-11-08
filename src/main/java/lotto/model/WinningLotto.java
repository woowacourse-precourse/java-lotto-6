package lotto.model;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Prize> calculateTotalPrize(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::calculatePrize)
                .toList();
    }

    private Prize calculatePrize(Lotto lotto) {
        return Prize.getRank(getEqualWinningNumber(lotto), isEqualBonusNumber(lotto));
    }

    private int getEqualWinningNumber(Lotto lotto) {
        return (int) lotto.getLotto().stream()
                .filter(winningLotto.getLotto()::contains)
                .count();
    }

    private boolean isEqualBonusNumber(Lotto lotto) {
        return lotto.getLotto().contains(bonusNumber);
    }
}