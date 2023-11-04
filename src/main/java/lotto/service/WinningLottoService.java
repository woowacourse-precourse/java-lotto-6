package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.repository.WinningLottoRepository;

public class WinningLottoService {
    private final WinningLottoRepository winningLottoRepository;

    public WinningLottoService(WinningLottoRepository winningLottoRepository) {
        this.winningLottoRepository = winningLottoRepository;
    }

    public void saveWinningLotto(Lotto lotto, int bonus) {
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        winningLottoRepository.save(winningLotto);
    }
}
