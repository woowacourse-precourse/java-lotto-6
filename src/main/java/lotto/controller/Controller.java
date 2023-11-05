package lotto.controller;

import java.util.List;
import lotto.model.LottoManager;
import lotto.model.PrizeManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    InputView input = new InputView();
    OutputView output = new OutputView();
    LottoManager lotto = new LottoManager();
    PrizeManager prize = new PrizeManager();

    public void startGame() {
        while (true) {
            try {
                String amount = input.getUserBuyAmount();
                lotto.buyTickets(amount);
                break;
            } catch (IllegalArgumentException e) {
                output.displayBuyError();
            }
        }

        List<String> list = lotto.getTickets();
        output.displayBoughtTickets(list);

        String winning = input.getPrizingNumbers();
        String bonus = input.getBonusNumbers();

        List<Integer> points = lotto.checkTicketPoints(winning, bonus);
        prize.checkTicketAndAddPrizes(points);
        List<Integer> counts = prize.getPrizeCounts();
        output.displayRankCounts(counts);

        double profitRatio = prize.getProfitRatio();
        output.displayProfitRatio(profitRatio);
    }

}
