package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.parser.Parser;
import lotto.util.Generator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    public static void start() {
        // 구입금액
        String purchaseAmount = InputView.requestPurchaseAmount();
        int ticketAmount = Parser.parsePurchaseAmount(purchaseAmount);
        List<Lotto> tickets = Generator.publishTickets(ticketAmount);
        OutputView.responseTickets(ticketAmount, tickets);

        // 당첨 번호
        String winningNumbers = InputView.requestWinningNumbers();
        Lotto winnigLotto = Parser.parseWinningNumbers(winningNumbers);

        // 보너스 번호
        String bonusNumber = InputView.requestBonusNumber();
        int bonusLotto = Parser.parseBonusNumber(bonusNumber);


    }
}
