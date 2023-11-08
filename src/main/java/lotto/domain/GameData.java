package lotto.domain;

import java.util.List;
import java.util.Map;

public class GameData {
    private final Lotto winningNumbers;
    private final int bonusNumber;
    private final List<Lotto> lottos;

    private Map<Rank, Integer> results;

    public void setResults(Map<Rank, Integer> results) {
        this.results = results;
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public GameData(Lotto winningNumbers, int bonusNumber, List<Lotto> lottos) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
