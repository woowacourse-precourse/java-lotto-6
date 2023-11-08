package controller;

import domain.LottoCount;
import view.InputView;

public class Controller {
    public void run() {

        int purchaseAmount = InputView.purchaseAmount();

        LottoCount lottoCount = new LottoCount(purchaseAmount);
    }


}
