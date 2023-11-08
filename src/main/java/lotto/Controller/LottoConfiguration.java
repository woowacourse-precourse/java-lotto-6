package lotto.Controller;

import lotto.LottoFactory.LottoContainer;
import lotto.LottoFactory.LottoController;

public class LottoConfiguration {
    LottoContainer lottoContainer;
    LottoController lottoController;

    public LottoConfiguration(LottoContainer lottoContainer, LottoController lottoController) {
        this.lottoContainer = lottoContainer;
        this.lottoController = lottoController;
    }

    public LottoContainer getLottoContainer() {
        return lottoContainer;
    }

    public LottoController getLottoController() {
        return lottoController;
    }

}
