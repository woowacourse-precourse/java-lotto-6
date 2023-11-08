package lotto.controller;

import java.util.HashMap;
import lotto.View.OutputView;
import lotto.domain.Buyer;
import lotto.domain.DrawMachine;
import lotto.domain.Rank;
import lotto.service.GameService;

public class GameController {
    Buyer buyer = new Buyer();
    DrawMachine drawMachine = new DrawMachine();
    GameService gameService = new GameService();
    HashMap<Rank, Integer> result;

    public void run() {
        beforeDraw();
        Draw();
        afterDraw();
    }

    private void beforeDraw() {
        buyer.buyLotto();
    }

    private void Draw() {
        drawMachine.makeWinningNumber();
        drawMachine.makeBonusNumber();
    }

    private void afterDraw() {
        result = gameService.getResult(buyer.getBuyList(),
                drawMachine.getWinningNumber(), drawMachine.getBonusNumber());
        OutputView.printStatistic();
        OutputView.printResult(result);
        OutputView.printRevenue(gameService.getPrizeSum(result), buyer.getBuyCount());
    }
}
