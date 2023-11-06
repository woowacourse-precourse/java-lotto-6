package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final LottoMachine lottoMachine;
    private final Map<Integer, Integer> winningResult;

    public LottoGame() {
        this.lottoMachine = new LottoMachine();
        this.winningResult = new HashMap<>();
        for (int i = 0; i <= Lotto.NUMBER_COUNT; i++) {
            winningResult.put(i, 0);
        }
    }

    public List<Lotto> purchaseLottoTickets(int count) {
        return lottoMachine.createLottoTickets(count);
    }

    public Lotto drawWinningLotto() {
        return lottoMachine.createWinningLotto();
    }

    public void play(List<Lotto> lottoTickets, Lotto winningLotto) {
        for (Lotto lotto : lottoTickets) {
            int matchedCount = lotto.countMatchedNumbers(winningLotto);
            winningResult.put(matchedCount, winningResult.get(matchedCount) + 1);
        }
    }

    public Map<Integer, Integer> getWinningResult() {
        return winningResult;
    }
}
