package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    public Player createPlayer(int purchaseAmount) {
        return new Player(purchaseAmount);
    }

    public WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public Map<Rank, Integer> makeWinningStatistics(Player player, WinningLotto winningLotto) {
        Map<Rank, Integer> winningStatistics = initWinningStatistics();
        List<Lotto> lottos = player.getLottos();

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.getRank(lotto);
            winningStatistics.put(rank, winningStatistics.get(rank) + 1);
        }

        return sortWinningStatistics(winningStatistics);
    }

    private Map<Rank, Integer> initWinningStatistics() {
        Map<Rank, Integer> winningStatistics = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values())
            winningStatistics.put(rank, 0);
        return winningStatistics;
    }

    private Map<Rank, Integer> sortWinningStatistics(Map<Rank, Integer> winningStatistics) {
        return winningStatistics.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(Rank.NONE))
                .sorted(Comparator.comparingInt(entry -> entry.getKey().getPrizeMoney()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private int calculateTotalPrizeMoney(Map<Rank, Integer> winningStatistics) {
        int totalPrizeMoney = 0;
        for (Rank rank : winningStatistics.keySet()) {
            Integer winningNumber = winningStatistics.get(rank);
            totalPrizeMoney += rank.getPrizeMoney() * winningNumber;
        }
        return totalPrizeMoney;
    }

    public double calculateReturnOfRatio(Player player, Map<Rank, Integer> winningStatistics) {
        int totalPrizeMoney = calculateTotalPrizeMoney(winningStatistics);
        return player.calculateRateOfReturn(totalPrizeMoney);
    }


}
