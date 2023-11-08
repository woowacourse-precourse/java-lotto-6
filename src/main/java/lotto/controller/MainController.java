package lotto.controller;

import lotto.model.AnswerLotto;
import lotto.model.LottoManager;
import lotto.model.Token;
import lotto.util.RepeatModule;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController extends RepeatModule {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoManager lottoManager;

    public MainController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        buy();
        setWinningLotto();
        result();
    }

    private void buy() {
        Token token = repeat(inputView::readToken);
        lottoManager = new LottoManager(token);

        lottoManager.ticket();
        outputView.printTicketingLottos(lottoManager.ticketedCount(), lottoManager.toString());
    }

    private void setWinningLotto() {
        AnswerLotto answerLotto = repeat(inputView::readAnswerLotto);
        repeat(inputView::readBonusNo, answerLotto::registerBonusNo);
        lottoManager.registerAnswerLotto(answerLotto);
    }

    private void result() {
        outputView.printScore(lottoManager.calScore());
        outputView.printEarningRate(lottoManager.calEarningRate());
    }
}
