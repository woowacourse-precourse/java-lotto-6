package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.WinningManager;
import lotto.view.OutputView;

public class StatisitcsController {

    private BuyingLottoController buyingLottoController = new BuyingLottoController();
    private DrawWinningNumberController drawWinningNumberController = new DrawWinningNumberController();

    public void drawLotto(){
        Buyer buyer = buyingLottoController.buyLotto();
        WinningManager manager = drawWinningNumberController.drawWinningNumber();

        buyer.checkMyFate(manager);
        manager.calculateWinningRate(buyer.getWinningLotto(),buyer.getLottoAmount());

        OutputView.outputWinningStatisitcs(buyer.getWinningLotto(),manager.getWinningRate());
    }
}
