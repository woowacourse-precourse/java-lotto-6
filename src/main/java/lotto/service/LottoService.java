package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.domain.Rank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private Lottos lottos;
    private WinningNumbers winningNumbers;

    public String getLottosOutput() {
        return lottos.toString();
    }

    public void initWinningNumbers() {
        this.winningNumbers = new WinningNumbers();
    }

    public void initLottos(List<Lotto> lottos) {
        this.lottos = new Lottos(lottos);
    }

    public void initWinningLotto(String input) {
        winningNumbers.initWinningLotto(input);
    }

    public void initBonusNumber(String input) {
        winningNumbers.initBonusNumber(input);
    }

    public Map<Rank, Integer> createStatistics() {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        List<Rank> ranks = List.of(Rank.values());
        ranks.forEach(rank -> statistics.put(rank, 0));
        lottos.getStream()
                .map(lotto -> Rank.getRank(winningNumbers.getMatchNumber(lotto), winningNumbers.hasBonusNumber(lotto)))
                .forEach(rank -> statistics.put(rank, statistics.get(rank) + 1));
        return statistics;
    }
}
