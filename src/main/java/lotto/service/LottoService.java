package lotto.service;

import lotto.Lotto;
import lotto.LottoPublisher;
import lotto.LottoResult;
import lotto.repository.LottoRepository;

import java.util.List;

public class LottoService {

    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public List<Lotto> purchaseLotto(final Long purchaseAmount) {
        LottoPublisher lottoPublisher = new LottoPublisher();
        List<Lotto> lottos = lottoPublisher.publishLotto(purchaseAmount);
        lottoRepository.saveAll(lottos);
        return lottos;
    }

    public LottoResult compareLotto(final List<Integer> winningNumbers, final Integer bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        List<Lotto> lottos = lottoRepository.findAll();
        return lottoResult.showLottoResult(winningNumbers, bonusNumber, lottos);
    }
}
