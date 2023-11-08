package lotto;

import java.util.ArrayList;
import java.util.List;

public class CalculateLotto {

    protected int calculateLottoGame(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> resultLotto = new ArrayList<>(lotto.getNumbers());
        resultLotto.retainAll(winningLotto.getLotto().getNumbers());
        return resultLotto.size();
    }

    protected boolean calculateLottoGameBonus(Lotto lotto, WinningLotto winningLotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNumber());
    }
}
