package lotto.controller;

import lotto.service.LottoService;
import lotto.util.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    public void investInLotto() {
        while (true) {
            try {
                int purchaseAmount = Converter.convertPurchaseAmount(InputView.readPurchaseAmount());
                lottoService.buyLotto(purchaseAmount);
                OutputView.printBuyResults(lottoService.createBuyResults());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
