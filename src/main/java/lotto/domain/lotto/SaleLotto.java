package lotto.domain.lotto;

import java.util.List;

public class SaleLotto extends Lotto{

    public SaleLotto(List<Integer> numbers) {
        super(numbers);
    }

    public Rank checkLottoRank(WinningLotto winningLotto) {
        int matchCount = matchNumberCount(winningLotto);
        boolean matchBonus = winningLotto.isBonusNumberIn(this);
        return Rank.of(matchCount, matchBonus);
    }
}
