package lotto.domain;

import java.util.List;

public class LottoAnalyzer {
    private final List<Lotto> lottos;
    private List<Integer> winningNumbers;

    public LottoAnalyzer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void addWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }
}
