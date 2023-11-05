package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

//    OutputView outputView = new OutputView();
//    InputView inputView = new InputView();

    public void startLotto() {
        OutputView.printGetPurchasePriceMessage();
        int purchasePrice = InputView.inputPurchasePrice();

        int lottoNum = getLottoNum(purchasePrice);
        OutputView.printLottoNumMessage(lottoNum);
    }

    public int getLottoNum(int purchasePrice) {
        int lottoNum = purchasePrice / 1000;
        return lottoNum;
    }
}
