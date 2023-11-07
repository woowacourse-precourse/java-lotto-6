package lotto.domain;

public class LottoPurchaseMachine {

    LottoRepository lottoRepository;

    public LottoPurchaseMachine() {
        lottoRepository = new LottoRepository();
    }

    public Lottos purchaseLottos(int lottoCount) {
        return lottoRepository.makeLottos(lottoCount);
    }
}
