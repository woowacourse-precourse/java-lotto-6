package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class Calculator {
    private final Lotto winnerLotto;
    private final List<Lotto> userLottos;
    private final int bonusNumber;

    public Calculator(Lotto winnerLotto, List<Lotto> userLottos, int bonusNumber) {
        this.winnerLotto = winnerLotto;
        this.userLottos = userLottos;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumber(Lotto winnerLotto, Lotto userLotto) {
        return winnerLotto.countMatchingNumber(userLotto);
    }

    public Map<Rank, Integer> getCalculateResult() {
        Map<Rank, Integer> calculateResult = new HashMap<>();
        for (Lotto userLotto : userLottos) {
            Rank rank = Rank.decideRank(countMatchingNumber(winnerLotto, userLotto), userLotto.contains(bonusNumber));
            calculateResult.put(rank, calculateResult.getOrDefault(rank, 0) + 1);
        }
        return calculateResult;
    }

}
