package lotto.service;

import lotto.domain.*;

import java.util.List;

public class LottoService {
    private LottoMarket lottoMarket = new LottoMarket(new RandomNumbersGenerator());
    private LottoBuyer lottoBuyer;

    public void buyLotto(Money money) {
        List<Lotto> lottos = lottoMarket.sellLotto(money);
        lottoBuyer = new LottoBuyer(lottos);
    }

    public List<Lotto> findLottos() {
        return lottoBuyer.getLottos();
    }
}
