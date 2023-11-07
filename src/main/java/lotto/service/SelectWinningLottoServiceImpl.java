package lotto.service;

import lotto.dto.LottoAndBonusNumberDTO;
import lotto.model.WinningLotto;
import lotto.repository.WinningLottoRepository;

public class SelectWinningLottoServiceImpl implements SelectWinningLottoService {
    private final WinningLottoRepository winningLottoRepository;

    public SelectWinningLottoServiceImpl(WinningLottoRepository winningLottoRepository) {
        this.winningLottoRepository = winningLottoRepository;
    }

    @Override
    public void select(LottoAndBonusNumberDTO lottoAndBonusNumberDTO) {
        WinningLotto winningLotto = new WinningLotto(
                lottoAndBonusNumberDTO.getLottoNumbers(),
                lottoAndBonusNumberDTO.getBonusNumber()
        );

        winningLottoRepository.save(winningLotto);
    }
}
