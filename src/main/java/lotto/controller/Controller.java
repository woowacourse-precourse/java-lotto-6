package lotto.controller;

import java.util.List;
import lotto.model.LottoManager;
import lotto.model.PrizeManager;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    InputView input = new InputView();
    OutputView output = new OutputView();
    LottoManager lotto = new LottoManager();
    PrizeManager prize = new PrizeManager();
    Validator valid = new Validator();


    public void startGame() {
        getUserBuyAmount();
        buyTickets();
        String winning = getUserPrizingNumbers();
        String bonus = getUserBonusNumbers();
        displayGameResult(winning, bonus);
    }


    private void getUserBuyAmount() {
        while (true) {
            try {
                String amount = input.getUserBuyAmount();
                lotto.buyTickets(amount);
                break;
            } catch (IllegalArgumentException e) {
                output.displayBuyError();
            }
        }
    }

    private void buyTickets() {
        List<String> list = lotto.getTickets();
        output.displayBoughtTickets(list);
    }

    private String getUserPrizingNumbers() {
        String winning;
        while (true) {
            try {
                winning = input.getPrizingNumbers();
                valid.validateWinningNumber(winning);
                return winning;
            } catch (IllegalArgumentException e) {
                output.displayWinningError();
            }
        }
    }

    private String getUserBonusNumbers() {
        String bonus;
        while (true) {
            try {
                bonus = input.getBonusNumbers();
                valid.validateBonusNumber(bonus);
                return bonus;
            } catch (IllegalArgumentException e) {
                output.displayBonusError();
            }
        }
    }

    private void displayGameResult(String winning, String bonus) {
        List<Integer> points = lotto.checkTicketPoints(winning, bonus);
        prize.checkTicketAndAddPrizes(points);

        List<Integer> counts = prize.getPrizeCounts();
        output.displayRankCounts(counts);

        double profitRatio = prize.getProfitRatio();
        output.displayProfitRatio(profitRatio);
    }

}
