package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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

        return winningStatistics;
    }

    public Map<Rank, Integer> initWinningStatistics() {
        Map<Rank, Integer> winningStatistics = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values())
            winningStatistics.put(rank, 0);
        return winningStatistics;
    }

}
