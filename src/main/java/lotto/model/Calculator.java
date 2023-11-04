package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class Calculator {
    private static final int LOTTO_PRICE = 1000;
    private final Lotto winnerLotto;
    private final List<Lotto> userLottos;
    private final int bonusNumber;

    public Calculator(Lotto winnerLotto, List<Lotto> userLottos, int bonusNumber) {
        this.winnerLotto = winnerLotto;
        this.userLottos = userLottos;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> getCalculateResult() {
        Map<Rank, Integer> calculateResult = new HashMap<>();
        for (Lotto userLotto : userLottos) {
            Rank rank = Rank.decideRank(winnerLotto.countMatchingNumber(userLotto), userLotto.contains(bonusNumber));
            calculateResult.put(rank, calculateResult.getOrDefault(rank, 0) + 1);
        }
        return calculateResult;
    }

    public float calculateRateOfReturn(Map<Rank, Integer> result) {
        long sumOfPrize = 0;
        for (Rank rank : Rank.values()) {
            sumOfPrize += result.getOrDefault(rank, 0) * rank.getPrize();
        }
        return (float) sumOfPrize / userLottos.size() / LOTTO_PRICE * 100;
    }

}
