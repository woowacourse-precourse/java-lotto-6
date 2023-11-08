package lotto;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;
    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }
    public void calculateWinning(StandardLotto standardLotto){
        this.lottoList.forEach(lotto -> WinningCalculator.addCount(standardLotto.matchPrize(lotto)));
    }
}
