package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.WinningManager;
import lotto.view.OutputView;

public class StatisitcsController {

    private final BuyingLottoController buyingLottoController = new BuyingLottoController();
    private final DrawWinningNumberController drawWinningNumberController = new DrawWinningNumberController();

    public void playLotto(){
        Buyer buyer = buyingLottoController.buyLotto();
        WinningManager manager = drawWinningNumberController.drawWinningNumber();

        buyer.checkEachLottoLine(manager);
        manager.calculateRevenue(buyer);

        OutputView.outputWinningStatisitcs(buyer.getWinningLotto(),manager.getWinningRate());
    }
}
