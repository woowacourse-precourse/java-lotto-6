package controller;

import domain.LottoCount;
import view.InputView;
import view.OutputView;

public class Controller {
    public void run() {

        int purchaseAmount = InputView.purchaseAmount();

        LottoCount lottoCount = new LottoCount(purchaseAmount);
        OutputView.printLottoCount(lottoCount.getLottoCount());
        OutputView.printLotties(lottoCount.getLotties());

        
    }


}
