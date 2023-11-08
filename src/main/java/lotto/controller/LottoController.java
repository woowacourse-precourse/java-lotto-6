package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.utils.PurchasePriceValidator;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService = new LottoService();

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int purchasePrice = getPurchasePrice();
        List<Lotto> lottos = purchaseLottos(purchasePrice);
    }

    private int getPurchasePrice() {
        String input = inputView.getPurchasePrice();
        PurchasePriceValidator.validIsInt(input);
        int purchasePrice = Integer.parseInt(input);
        PurchasePriceValidator.validIsMultiplesOfThousand(purchasePrice);
        return purchasePrice;
    }

    private List<Lotto> purchaseLottos(int price) {
        List<Lotto> lottos = lottoService.publishLottos(price);
        outputView.printPurchaseLottos(lottos);
    }

}
