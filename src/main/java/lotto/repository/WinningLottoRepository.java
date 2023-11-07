package lotto.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.WinningLotto;

public class WinningLottoRepository {
    private static final int ID = 1;
    private static final Map<Integer, WinningLotto> winningLottoDB = new ConcurrentHashMap<>();

    public void save(WinningLotto winningLotto) {
        winningLottoDB.put(ID, winningLotto);
    }

    public WinningLotto find() {
        return winningLottoDB.get(ID);
    }
}
