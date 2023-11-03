package lotto.model;

import java.util.List;
import lotto.Lotto;

public class Calculator {
    private final Lotto winnerLotto;
    private final List<Lotto> userLottos;

    public Calculator(Lotto winnerLotto, List<Lotto> userLottos) {
        this.winnerLotto = winnerLotto;
        this.userLottos = userLottos;
    }

    public int countMatchingNumber(Lotto winnerLotto, Lotto userLotto) {
        return winnerLotto.countMatchingNumber(userLotto);
    }

}
