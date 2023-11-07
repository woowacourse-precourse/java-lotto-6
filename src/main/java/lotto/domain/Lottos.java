package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void createLottos(int buyLottoCount) {
        createLottos(buyLottoCount, 1, 45, 6);
    }

    public void createLottos(int buyLottoCount, int startInclusive, int endInclusive, int count) {
        for(int i = 0; i < buyLottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count));
            lottos.add(lotto);
        }
    }

    public int[] checkWinnings(int[] winningNumbers, int bonusNumber) {
        int[] winningCounts = new int[lottos.size()];
        for(int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            winningCounts[i] = lotto.checkWinning(winningNumbers, bonusNumber);
        }
        return winningCounts;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

}
