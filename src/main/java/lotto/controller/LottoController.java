package lotto.controller;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.domain.WinningLotto.convertToIntegerList;

public class LottoController {
    public void start() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> tickets = lottoMachine.issueTickets(purchaseAmount);
        OutputView.printTickets(tickets);

        String winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        List<Integer> winningNumberList = convertToIntegerList(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumberList), bonusNumber);

        LottoResult result = winningLotto.compare(tickets);
        OutputView.printResult(result, purchaseAmount);
    }
}
