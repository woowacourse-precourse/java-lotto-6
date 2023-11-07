package lotto;

import lotto.InputValidator;
import lotto.Lotto;
import lotto.LottoShop;
import lotto.LottoTicket;

import java.util.List;

public class LottoGame {

    public void startGame() {
        // 게임 시작
        LottoShop lottoShop = new LottoShop();
        Lotto winningLotto = Lotto.createRandomLotto();

        LottoTicket purchasedTickets = lottoShop.buyLottoTicket();
        List<Lotto> lottos = purchasedTickets.getLottos();

        InputValidator validator = new InputValidator();
        List<Integer> winningNumbers = validator.getValidWinningNumbers();
        int bonusNumber = validator.getValidBonusNumber();

        ResultChecker resultChecker = new ResultChecker();
        int matchCount;
        int totalMatchCount = 0;
        int manualTicketCount = 0;

        for (Lotto lotto : lottos) {
            matchCount = resultChecker.checkResult(lotto, winningLotto, winningNumbers, bonusNumber);
            if (matchCount == Lotto.LOTTO_SIZE) {
                manualTicketCount++;
            }
            totalMatchCount += matchCount;
        }

        ResultPrinter resultPrinter = new ResultPrinter();
        resultPrinter.printResult(winningLotto, winningNumbers, bonusNumber, lottos.size(), manualTicketCount, totalMatchCount);

        ProfitCalculator profitCalculator = new ProfitCalculator();
        profitCalculator.calculateProfit(lottos.size(), totalMatchCount);
    }
}