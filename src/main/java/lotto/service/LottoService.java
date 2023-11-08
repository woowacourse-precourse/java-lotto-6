package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.model.Lotties;
import lotto.model.Lotto;
import lotto.model.Rank;

public class LottoService {

    public Lotties buyLotties(int money) {
        return new Lotties(generateLotties(money));
    }

    private List<Lotto> generateLotties(int money) {
        List<Lotto> lotties = new ArrayList<>();
        for (int i = 0; i < money / Lotto.PRICE_PER_LOTTO; i++) {
            lotties.add(generateLotto());
        }
        return lotties;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public double getProfitability(EnumMap<Rank, Integer> rankCounts, int money) {
        double profitability = 0L;
        for (Rank rank : Rank.values()) {
            int winning = rank.getPrize();
            int matchLottoCount = rankCounts.getOrDefault(rank, 0);
            profitability += matchLottoCount * winning;
        }
        return profitability / money * 100;
    }

    public EnumMap<Rank, Integer> getWinningStatistics(Lotties purchasedLotties, Lotto winningLotto, int bonusNumber) {
        EnumMap<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        for (int i = 0; i < purchasedLotties.size(); i++) {
            Lotto lotto = purchasedLotties.get(i);
            Rank rank = lotto.determineRank(winningLotto, bonusNumber);
            if (rank != null) {
                int count = rankCounts.getOrDefault(rank, 0);
                rankCounts.put(rank, count + 1);
            }
        }
        return rankCounts;
    }
}
