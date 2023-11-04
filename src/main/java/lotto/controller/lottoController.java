package lotto.controller;

import lotto.exception.ExceptionHandler;
import lotto.model.LottoGameHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class lottoController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameHandler lottoGameHandler = new LottoGameHandler();
    ExceptionHandler exceptionHandler = new ExceptionHandler();

    public void start() {


        inputView.lottoPurchaseAmount();

        lottoGameHandler.purchaseLotto();

        lottoGameHandler.createLotto();

        outputView.lottoTickets();

        inputView.winningNumbers();

        inputView.bonusNumber();

        lottoGameHandler.createWinningTicket();

        lottoGameHandler.checkWinningResult();

        lottoGameHandler.checkWinningResult();

        outputView.winningRecords();

        outputView.prizesSummary();



    }

}
