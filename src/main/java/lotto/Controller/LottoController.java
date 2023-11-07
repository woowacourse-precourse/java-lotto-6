package lotto.Controller;

import lotto.Domain.*;
import lotto.Util.Parser;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;
import java.util.Map;


public class LottoController {

    LottoTicket lottoTicket;
    Budget budget;

    public void run() {
        buyLottoTicket();
        List<Integer> winNumbers = getWinNumbers();
        WinningNumbers winningNumbers = createWinningNumbers(winNumbers);
        countRankAndCalculatePrize(winningNumbers);
    }

    private void buyLottoTicket() {
        try {
            String budgetInput = InputView.requestBudget();
            budget = new Budget(budgetInput);
            int lottoCount = budget.calculateLottoCount();
            lottoTicket = new LottoTicket(lottoCount);
            OutputView.printLottosSize(lottoTicket.getSize());
            OutputView.printLottosNumbers(lottoTicket.getLottoString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyLottoTicket();
        }
    }

    private static List<Integer> getWinNumbers() {
        try {
            String winNumInput = InputView.requestWinningNum();
            return Parser.convertStringToNumbers(winNumInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinNumbers();
        }
    }

    private static WinningNumbers createWinningNumbers(List<Integer> winNumbers) {
        try {
            String bonusNumInput = InputView.requestBonusNum();
            return new WinningNumbers(winNumbers, bonusNumInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningNumbers(winNumbers);
        }
    }

    private void countRankAndCalculatePrize(WinningNumbers winningNumbers) {
        Map<Rank, Integer> rankCount = winningNumbers.getRankCount(lottoTicket.getLottoTicket());
        double returnRate = budget.calculateReturnRate(rankCount);
        OutputView.printRankCount(rankCount);
        OutputView.printReturnRate(returnRate);
    }
}
