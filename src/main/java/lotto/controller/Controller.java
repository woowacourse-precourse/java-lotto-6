package lotto.controller;

import java.util.List;
import lotto.model.LottoManager;
import lotto.model.PrizeManager;
import lotto.model.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    InputView input = new InputView();
    OutputView output = new OutputView();
    LottoManager lotto = new LottoManager();
    PrizeManager prize = new PrizeManager();
    Validator valid = new Validator();

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

        String winning;
        while (true) {
            try {
                winning = input.getPrizingNumbers();
                valid.validateWinningNumber(winning);
                break;
            } catch (IllegalArgumentException e) {
                output.displayWinningError();
            }
        }

        String bonus;
        while (true) {
            try {
                bonus = input.getBonusNumbers();
                valid.validateBonusNumber(bonus);
                break;
            } catch (IllegalArgumentException e) {
                output.displayBonusError();
            }
        }

        List<Integer> points = lotto.checkTicketPoints(winning, bonus);
        prize.checkTicketAndAddPrizes(points);
        List<Integer> counts = prize.getPrizeCounts();
        output.displayRankCounts(counts);

        double profitRatio = prize.getProfitRatio();
        output.displayProfitRatio(profitRatio);
    }

}
