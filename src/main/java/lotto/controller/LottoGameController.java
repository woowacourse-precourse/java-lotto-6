package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningNumber;
import lotto.domain.Money;
import lotto.domain.Profit;
import lotto.service.LottoDrawService;
import lotto.service.LottoIssueService;
import lotto.service.LottoWinningNumberService;
import lotto.service.MoneyService;
import lotto.view.OutputView;

public class LottoGameController {

    public static void start() {
        Money money = getMoney();
        OutputView.printLottoAmount(money);
        LottoTicket lottoTicket = issueTicket(money.calculateLottoAmount());

        Lotto winningNumbers = getLotto();
        LottoWinningNumber lottoWinningNumber = getLottoWinningNumber(winningNumbers);
        LottoResult lottoResult = draw(lottoTicket, lottoWinningNumber);
        OutputView.printProfit(new Profit(money, lottoResult.getTotalPrize()));
    }

    private static Money getMoney() {
        Money money;
        try {
            money = MoneyService.createMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
        return money;
    }

    private static Lotto getLotto() {
        Lotto winningsNumbers;
        try {
            winningsNumbers = LottoWinningNumberService.generateLottoWinningNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLotto();
        }
        return winningsNumbers;
    }

    private static LottoWinningNumber getLottoWinningNumber(Lotto winningNumbers) {
        LottoWinningNumber lottoWinningNumber;
        try {
            int bonusNumber = LottoWinningNumberService.generateBonusNumber();
            lottoWinningNumber = new LottoWinningNumber(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoWinningNumber(winningNumbers);
        }
        return lottoWinningNumber;
    }

    private static LottoTicket issueTicket(int lottoAmount) {
        LottoTicket lottoTicket = LottoIssueService.createLottoTicket(lottoAmount);
        OutputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private static LottoResult draw(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        LottoResult lottoResult = new LottoResult(LottoDrawService.drawLotto(lottoTicket, lottoWinningNumber));
        OutputView.printLottoResult(lottoResult.getLottoResult());
        return lottoResult;
    }
}