package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lotto.Lotto;

public class LottoBundle {
    private final List<Lotto> lotteries;

    public LottoBundle(List<List<Integer>> lotteries) {
        this.lotteries = createLottos(lotteries);
    }

    private List<Lotto> createLottos(List<List<Integer>> lotteries) {
        return lotteries.stream().map(Lotto::new).toList();
    }

    public Map<Rank, Integer> checkRankings(Lotto winnerLotto, Bonus bonus) {
        Map<Rank, Integer> winningLottoTable = new HashMap<>();
        for (Lotto lotto : lotteries) {
            Rank rank = findRank(winnerLotto, bonus, lotto);
            addNumberOfRankings(winningLottoTable, rank);
        }
        return winningLottoTable;
    }

    private Rank findRank(Lotto winnerLotto, Bonus bonus, Lotto lotto) {
        int countOfMatch = lotto.compare(winnerLotto);
        boolean containsBonus = lotto.hasBonus(bonus.getBonusNumber());
        return Rank.valueOf(countOfMatch, containsBonus);
    }

    private void addNumberOfRankings(Map<Rank, Integer> winningLottoTable, Rank rank) {
        winningLottoTable.put(rank, winningLottoTable.getOrDefault(rank, 0) + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoBundle that = (LottoBundle) o;
        return Objects.equals(lotteries, that.lotteries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteries);
    }
}
