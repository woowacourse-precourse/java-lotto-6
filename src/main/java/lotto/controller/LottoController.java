package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.Result;
import lotto.domain.WinningNum;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final LottoTickets lottoTickets;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoTickets = new LottoTickets();
    }

    public void run() {
        Integer money = inputView.inputMoney();
        lottoTickets.buyLotto(money);
        OutputView.buyComplete(money);
        OutputView.printLotto(lottoTickets);

        WinningNum winningNum = inputView.winningNumber();

        inputView.bonusNumber(winningNum);

        Result result = lottoTickets.getResult(winningNum);
        OutputView.resultMessage(result,money);
    }
}
