package lotto.service;

import lotto.repository.LottoRepository;
import lotto.repository.WinningRepository;

public class LottoService {

    private final LottoRepository lottoRepository;
    private final WinningRepository winningRepository;

    public LottoService(LottoRepository lottoRepository, WinningRepository winningRepository) {
        this.lottoRepository = lottoRepository;
        this.winningRepository = winningRepository;
    }




}
