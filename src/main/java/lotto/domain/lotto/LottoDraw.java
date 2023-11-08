package lotto.domain.lotto;

import lotto.domain.prize.Prize;
import lotto.domain.prize.Prizes;
import lotto.domain.result.Result;

import java.util.List;

public class LottoDraw {
    private final Lotto lotto;
    private final Bonus bonus;

    public LottoDraw(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Prizes compare(List<Lotto> lottos) {
        List<Prize> prizes = lottos.stream()
                .map(l -> lotto.compare(l, bonus.number()))
                .map(Result::substitutePrize)
                .toList();

        return new Prizes(prizes);
    }
}
