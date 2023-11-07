package lotto.service;

import lotto.dto.LottoAndBonusDTO;
import lotto.model.WinningLotto;
import lotto.repository.WinningLottoRepository;

public class SelectWinningLottoServiceImpl implements SelectWinningLottoService {
    private final WinningLottoRepository winningLottoRepository;

    public SelectWinningLottoServiceImpl(WinningLottoRepository winningLottoRepository) {
        this.winningLottoRepository = winningLottoRepository;
    }

    @Override
    public void select(LottoAndBonusDTO lottoAndBonusDTO) {

        WinningLotto winningLotto = new WinningLotto(
                lottoAndBonusDTO.getLotto(),
                lottoAndBonusDTO.getBonus()
        );

        winningLottoRepository.save(winningLotto);
    }
}
