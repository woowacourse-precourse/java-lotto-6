package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NOTHING;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoBundle {
    private final List<Lotto> lotteries;

    public LottoBundle(List<List<Integer>> lotteries) {
        this.lotteries = createLotteries(lotteries);
    }

    private List<Lotto> createLotteries(List<List<Integer>> lotteries) {
        List<Lotto> sortedLotteries = new ArrayList<>();
        for (List<Integer> lottery : lotteries) {
            addSortedLottoNumbers(lottery, sortedLotteries);
        }
        return sortedLotteries;
    }

    private void addSortedLottoNumbers(List<Integer> lottery, List<Lotto> list) {
        List<Integer> sortedLottoNumbers = createSortedLottoNumbers(lottery);
        Lotto lotto = new Lotto(sortedLottoNumbers);
        list.add(lotto);
    }

    private List<Integer> createSortedLottoNumbers(List<Integer> lottery) {
        List<Integer> sortedLottoNumbers = new ArrayList<>(lottery);
        Collections.sort(sortedLottoNumbers);
        return sortedLottoNumbers;
    }

    public Map<Rank, Integer> checkRankings(Lotto winnerLotto, Bonus bonus) {
        Map<Rank, Integer> winningLottoTable = initWinningLottoTable();
        for (Lotto lotto : lotteries) {
            Rank rank = findRank(winnerLotto, bonus, lotto);
            addNumberOfRankings(winningLottoTable, rank);
        }
        return winningLottoTable;
    }

    private Map<Rank, Integer> initWinningLottoTable() {
        return Stream.of(FIFTH, FOURTH, THIRD, SECOND, FIRST)
                .collect(Collectors.toMap(rank -> rank, rank -> 0, (a, b) -> b, LinkedHashMap::new));
    }

    private Rank findRank(Lotto winnerLotto, Bonus bonus, Lotto lotto) {
        int countOfMatch = lotto.compare(winnerLotto);
        boolean containsBonus = lotto.hasBonus(bonus.getBonusNumber());
        return Rank.valueOf(countOfMatch, containsBonus);
    }

    private void addNumberOfRankings(Map<Rank, Integer> winningLottoTable, Rank rank) {
        if (rank != NOTHING) {
            winningLottoTable.put(rank, winningLottoTable.get(rank) + 1);
        }
    }

    public int size() {
        return lotteries.size();
    }

    public List<Lotto> getLotteries() {
        return lotteries;
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
