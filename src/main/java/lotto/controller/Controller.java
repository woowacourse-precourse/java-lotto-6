package lotto.controller;

import java.util.List;
import lotto.model.LottoManager;
import lotto.model.PrizeManager;
import lotto.utils.validation.ValidatorNumber;
import lotto.view.InputView;
import lotto.view.output.DisplayAnnounce;
import lotto.view.output.DisplayError;

public class Controller {
    InputView input = new InputView();
    DisplayAnnounce announce = new DisplayAnnounce();
    DisplayError error = new DisplayError();
    LottoManager lotto = new LottoManager();
    PrizeManager prize = new PrizeManager();
    ValidatorNumber validatorNumber = new ValidatorNumber();


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
                error.displayBuyError();
            }
        }
    }

    private void buyTickets() {
        List<String> list = lotto.getTickets();
        announce.displayBoughtTickets(list);
    }

    private String getUserPrizingNumbers() {
        String winning;
        while (true) {
            try {
                winning = input.getPrizingNumbers();
                validatorNumber.validateWinningNumber(winning);
                return winning;
            } catch (IllegalArgumentException e) {
                error.displayWinningError();
            }
        }
    }

    private String getUserBonusNumbers() {
        String bonus;
        while (true) {
            try {
                bonus = input.getBonusNumbers();
                validatorNumber.validateBonusNumber(bonus);
                return bonus;
            } catch (IllegalArgumentException e) {
                error.displayBonusError();
            }
        }
    }

    private void displayGameResult(String winning, String bonus) {
        List<Integer> points = lotto.getTicketPoint(winning, bonus);
        prize.calculatePrizesByPoints(points);

        List<Integer> counts = prize.getPrizeCounts();
        announce.displayRankCounts(counts);

        double profitRatio = prize.getProfitRatio();
        announce.displayProfitRatio(profitRatio);
    }

}
