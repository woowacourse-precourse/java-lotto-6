package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.utils.Parser;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private PurchaseController purchaseController = new PurchaseController();
    private LottoView lottoView = new LottoView();
    private InitLottoController initLottoController = new InitLottoController();
    private WinningNumberController winningNumberController = new WinningNumberController();

    private int ticketNumber;
    private List<Lotto> lotts  = new ArrayList<>();
    public void startLotto(){
        purchaseLotto();
        inputWinningNumber();
    }

    public void purchaseLotto(){
        ticketNumber = purchaseController.runPurchaseAmount();
        lottoView.outputPurchaseAmountView(ticketNumber);
        lotts = initLottoController.runInitLotto(ticketNumber);
        lottoView.printPurchaseLotto(lotts);
    }

    public void inputWinningNumber(){

        Lotto winningNumber = winningNumberController.runWinningNumber();
    }
}
