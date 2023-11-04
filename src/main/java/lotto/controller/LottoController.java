package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void run() {
        int purchasePrice = getPurchasePrice();
        int lottoCount = getLottoCount(purchasePrice);
        OutputView.printPurchaseLotto(lottoCount);
        Lottos lottos = new Lottos(lottoService.generateLotto(lottoCount));
        OutputView.printLottosValue(lottos.toResponseDto());
    }

    private int getLottoCount(int purchasePrice) {
        return purchasePrice / 1000;
    }

    private int getPurchasePrice() {
        OutputView.printInputPrice();
        return InputView.getPurchaseLottoPrice();
    }

}
