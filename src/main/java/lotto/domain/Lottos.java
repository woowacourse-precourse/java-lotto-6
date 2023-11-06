package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.util.LottoNumberGenerate;

public class Lottos {
    private final List<Lotto> lottos;
    private final List<Integer> winningCounts;

    public Lottos(int tryNumber) {
        this.lottos = LottoNumberGenerate.generateLottos(tryNumber);
        this.winningCounts = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public List<Integer> getWinningCounts() {
        return this.winningCounts;
    }

    public void addLottoRank(int count) {
        this.winningCounts.add(count);
    }

}
