package lotto.controller;

import lotto.model.Lottos;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private Lottos lottos;
    private WinningNumber winningNumber;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void createLottos(){
        int purchaseAmount = inputView.inputPurchaseAmount();
        lottos = new Lottos(purchaseAmount);
        outputView.showPurchase(lottos);
    }
    public void saveWinningNumber(){
        winningNumber = new WinningNumber(inputView.inputWinningNumbers(),inputView.inputBonusNumber());
    }
    public void showResult(){
        lottos.checkRank(winningNumber.getWinningNumbers(), winningNumber.getBonusNumber());
        outputView.showResult();
        outputView.showProfit(lottos.calculateProfit());
    }


}
