package lotto.repository;

import lotto.model.WinningLotto;

public class MemoryWinningLottoRepository implements WinningLottoRepository {
    private static WinningLotto store;

    @Override
    public void save(WinningLotto winningLotto) {
        store = winningLotto;
    }

    @Override
    public WinningLotto find() {
        return store;
    }
}
