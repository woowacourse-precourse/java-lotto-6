package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;
import lotto.view.LottoView;

public class LottoController {
    private PurchaseController purchaseController = new PurchaseController();
    public void startLotto(){
        purchaseController.processPurchaseAmount();
    }
}
