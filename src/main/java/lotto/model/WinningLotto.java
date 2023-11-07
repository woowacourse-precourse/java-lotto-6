package lotto.model;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getEqualWinningNumber(Lotto lotto) {
        return (int) lotto.getLotto().stream()
                .filter(winningLotto.getLotto()::contains)
                .count();
    }

    public boolean isEqualBonusNumber(Lotto lotto) {
        return lotto.getLotto().contains(bonusNumber);
    }

    public Prize calculatePrize(Lotto lotto) {
        return Prize.getRank(getEqualWinningNumber(lotto), isEqualBonusNumber(lotto));
    }

    public List<Prize> calculateTotalPrize(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::calculatePrize)
                .toList();
    }
}