package lotto.domain;

import lotto.model.Lottos;

public class LottoPurchaseMachine {

    LottoRepository lottoRepository;

    public LottoPurchaseMachine() {
        lottoRepository = new LottoRepository();
    }

    public Lottos purchaseLottos(int lottoCount) {
        return lottoRepository.makeLottos(lottoCount);
    }
}
