package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.util.Constants;

public class Calculator {
    private static final int PERCENTAGE = 100;
    private static final int NO_COUNT = 0;
    private static final int COUNT_ONE = 1;

    private final Lotto winnerLotto;
    private final List<Lotto> userLottos;
    private final int bonusNumber;

    public Calculator(Lotto winnerLotto, List<Lotto> userLottos, int bonusNumber) {
        this.winnerLotto = winnerLotto;
        this.userLottos = userLottos;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> countRank() {
        Map<Rank, Integer> countResult = new HashMap<>();
        for (Lotto userLotto : userLottos) {
            Rank rank = Rank.decideRank(winnerLotto.countMatchingNumber(userLotto), userLotto.contains(bonusNumber));
            countResult.put(rank, countResult.getOrDefault(rank, NO_COUNT) + COUNT_ONE);
        }
        return countResult;
    }

    public float calculateRateOfReturn(RankResult rankResult) {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += rankResult.getCountByRank(rank) * rank.getPrize();
        }
        return (float) totalPrize / userLottos.size() / Constants.LOTTO_PRICE * PERCENTAGE;
    }

}
