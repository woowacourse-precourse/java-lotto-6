package lotto.model;

import lotto.model.lottonumbersgenerator.LottoNumbersGenerator;

public class LottoBuyer {
    private Lottos lottos;

    public void buyLotto(int purchaseAmount, LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottos = LottoSeller.sellLotto(purchaseAmount, lottoNumbersGenerator);
    }
}
