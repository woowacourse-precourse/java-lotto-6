package lotto.service;

import lotto.dto.LottoAndBonusNumberDTO;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.repository.WinningLottoRepository;

public class SelectWinningLottoServiceImpl implements SelectWinningLottoService {
    private final WinningLottoRepository winningLottoRepository;

    public SelectWinningLottoServiceImpl(WinningLottoRepository winningLottoRepository) {
        this.winningLottoRepository = winningLottoRepository;
    }

    @Override
    public void select(LottoAndBonusNumberDTO lottoAndBonusNumberDTO) {
        Lotto lotto = new Lotto(lottoAndBonusNumberDTO.getLottoNumbers());
        Bonus bonus = new Bonus(lottoAndBonusNumberDTO.getBonusNumber());

        WinningLotto winningLotto = new WinningLotto(lotto, bonus);

        winningLottoRepository.save(winningLotto);
    }
}
