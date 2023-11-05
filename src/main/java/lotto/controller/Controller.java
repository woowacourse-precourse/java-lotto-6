package lotto.controller;

import java.util.List;
import lotto.model.LottoManager;
import lotto.model.PrizeManager;
import lotto.utils.validation.ValidatorNumber;
import lotto.view.InputView;
import lotto.view.output.DisplayAnnounce;
import lotto.view.output.DisplayError;

public class Controller {
    // Fields
    InputView input = new InputView();
    DisplayAnnounce announce = new DisplayAnnounce();
    DisplayError error = new DisplayError();
    LottoManager lotto = new LottoManager();
    PrizeManager prize = new PrizeManager();
    ValidatorNumber validatorNumber = new ValidatorNumber();


    // Features
    public void startGame() {
        getUserBuyAmount();
        displayOwnedTickets();

        String winning = getUserPrizingNumbers();
        String bonus = getUserBonusNumbers();

        requestGenerateGameResult(winning, bonus);
        displayGameResult();
    }


    // Internal Implements
    // View를 통해 사용자로부터 구매금액을 입력받고, Model에 티켓 구매를 요청한다.
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

    // Model에서 티켓 보유 현황을 받아와서, View를 통해 보여준다.
    private void displayOwnedTickets() {
        List<String> list = lotto.getTickets();
        announce.displayBoughtTickets(list);
    }

    // View를 통해 6자리의 당첨 번호를 입력받아 임시로 저장한다.
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

    // View를 통해 보너스 번호를 입력받아 임시로 저장한다.
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

    // 미리 입력받은 6자리의 당첨 번호와 보너스 번호를 Model에 전달하여 게임의 결과를 생성하도록 한다.
    private void requestGenerateGameResult(String winning, String bonus) {
        List<Integer> points = lotto.getTicketPoints(winning, bonus);
        prize.calculatePrizesByPoints(points);
    }

    // Model로부터 생성된 게임의 결과(당첨 현황, 수익률)를 받아와서 View를 통해 사용자에게 보여준다.
    private void displayGameResult() {
        List<Integer> counts = prize.getEachPrizeCounts();
        announce.displayRankCounts(counts);

        double profitRatio = prize.getProfitRatio();
        announce.displayProfitRatio(profitRatio);
    }

}
