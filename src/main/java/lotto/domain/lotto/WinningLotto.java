package lotto.domain.lotto;

import java.util.List;
import lotto.domain.ball.Ball;
import lotto.domain.lotto.validator.WinningValidator;
import lotto.domain.rank.Rank;

public class WinningLotto {

    private final Lotto lotto;
    private final Ball bonus;

    public WinningLotto(final Lotto lotto, final Ball bonus) {
        WinningValidator.validateWinning(lotto.getBalls(), bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public List<Rank> calculateRanks(final Lottos lottos) {
        return lottos.calculateRanks(this.lotto, this.bonus);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Ball getBonus() {
        return bonus;
    }
}
