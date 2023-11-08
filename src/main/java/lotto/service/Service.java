package lotto.service;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.Utils;

public class Service {
    private static final int MINIMUM_AMOUNT = 1000;
    private static final int BONUS_CONTAIN_COUNT = 1;
    private static final int BONUS_VACANT_COUNT = 0;
    private static final int INITIAL_COUNT = 0;
    private static final int INCREASE_COUNT = 1;
    private static final int INITIAL_TOTAL_PRIZE = 0;
    private static final int ROUND_CONSTANT_INT = 10;
    private static final double ROUND_CONSTANT_DOUBLE = 10.0;

    public void purchaseLottos(Buyer buyer) {
        int lottoCount = buyer.getAmount() / MINIMUM_AMOUNT;
        for (int i = 0; i < lottoCount; i++) {
            purchaseLotto(buyer);
        }
    }

    private void purchaseLotto(Buyer buyer) {
        Lotto lotto = createLottoNumbers();
        buyer.setLottos(lotto);
    }

    private Lotto createLottoNumbers() {
        List<Integer> generatedNumbers = Utils.createSortedLottoNumbers();
        return new Lotto(generatedNumbers);
    }

    public void checkLottoStats(Buyer buyer, Game game) {
        HashMap<Rank, Integer> result = buyer.getResult();

        for (Lotto lotto : buyer.getLottos()) {
            Rank rank = compareLotto(lotto, game);
            result.put(rank, result.getOrDefault(rank, INITIAL_COUNT) + INCREASE_COUNT);
        }
    }

    public Rank compareLotto(Lotto lotto, Game game) {
        int winningCount = Utils.countSameInteger(lotto.getNumbers(), game.getWinningNumbers());
        int bonusCount = compareBonusNumber(lotto.getNumbers(), game.getBonusNumber());
        return Rank.valueOfWinningBonusCount(List.of(winningCount, bonusCount));

    }

    private int compareBonusNumber(List<Integer> numbers, int bonusNumber) {
        int bonusCount = BONUS_VACANT_COUNT;
        if (numbers.contains(bonusNumber)) {
            bonusCount = BONUS_CONTAIN_COUNT;
        }
        return bonusCount;
    }

    public void calculateReturnRate(Buyer buyer) {
        // 수익률 = 총 당첨금액 / 구입금액 * 100
        double returnRate = (calculateTotalPrize(buyer.getResult()) / (double) buyer.getAmount()) * 100;
        double roundRate = Math.round(returnRate * ROUND_CONSTANT_INT) / ROUND_CONSTANT_DOUBLE;
        buyer.setReturnRate(roundRate);
    }

    private int calculateTotalPrize(HashMap<Rank, Integer> result) {
        int totalPrize = INITIAL_TOTAL_PRIZE;
        for (Rank rank : result.keySet()) {
            if (rank != null) {
                totalPrize += rank.getPrize() * result.get(rank);
            }
        }
        return totalPrize;
    }
}
