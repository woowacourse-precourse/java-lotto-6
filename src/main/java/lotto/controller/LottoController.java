package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;
import lotto.view.LottoView;

public class LottoController {
    private PurchaseController purchaseController = new PurchaseController();
    private LottoView lottoView = new LottoView();

    private int ticketNumber;
    public void startLotto(){
        ticketNumber = purchaseController.runPurchaseAmount();
        lottoView.outputPurchaseAmountView(ticketNumber);
    }
}
