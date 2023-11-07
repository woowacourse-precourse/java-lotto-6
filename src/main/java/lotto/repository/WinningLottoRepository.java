package lotto.repository;

import lotto.model.WinningLotto;

public interface WinningLottoRepository {
    void save(WinningLotto winningLotto);
    WinningLotto find();
}
