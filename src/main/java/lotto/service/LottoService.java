package lotto.service;

import lotto.domain.*;
import lotto.repository.LottoRepository;

import java.util.List;

public class LottoService {

    private final LottoRepository lottoRepository;

    public LottoService() {
        this.lottoRepository = new LottoRepository();
    }

    public List<Lotto> buyLotto(Integer purchaseAmount) {
        List<Lotto> lottos = LottoMachine.generateLottoByPurchaseAmount(purchaseAmount);
        lottoRepository.save(lottos);
        return lottos;
    }
}
