package lotto.controller;

import lotto.domain.*;
import lotto.dto.RequestCash;
import lotto.dto.RequestLottos;
import lotto.dto.RequestWinnerLotto;
import lotto.dto.LottoResult;
import lotto.util.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final NumberGenerator numberGenerator;

    public GameController(NumberGenerator numberGeneratorImp) {
        this.numberGenerator = numberGeneratorImp;
    }

    public void play() {
        gameProcess();
    }


    private void gameProcess() {
        try {
            Cash cash = depositCash();
            Lottos lottos = purchaseLotto(cash);
            WinnerLotto winnerLotto = getWinnerLotto();
            compareLottosWithWinnerLotto(lottos, winnerLotto, cash);
        } catch (IllegalStateException e) {
            outputView.printErrorMessage(e);
        }
    }


    private Cash depositCash() throws IllegalStateException {
        try {
            RequestCash requestCash = inputView.requestCash();
            return Cash.create(requestCash.depositAmount(),
                               requestCash.spendAmount());
        } catch (IllegalStateException e) {
            throw e;
        }
    }

    private Lottos purchaseLotto(Cash cash) {
        LottoMachine lottoMachine = LottoMachine.create(numberGenerator, cash);
        RequestLottos requestLottos = lottoMachine.purchaseLottos();
        Lottos lottos = Lottos.create(requestLottos.createLottoDummy());
        outputView.printPurchasedLottos(lottos);
        return lottos;
    }



    private WinnerLotto getWinnerLotto() throws IllegalStateException {
        try {
            RequestWinnerLotto requestWinnerLotto = inputView.requestWinnerLotto();
            WinnerLotto winnerLotto = WinnerLotto.create(
                    requestWinnerLotto.winnerNumbers(),
                    requestWinnerLotto.bonusNumber());
            return winnerLotto;
        } catch (IllegalStateException e) {
            throw e;
        }
    }

    private void compareLottosWithWinnerLotto(Lottos lottos, WinnerLotto winnerLotto, Cash cash) {
        LottoResult lottoResult = lottos.compareWithWinnerLotto(winnerLotto);
        Prizes prizes = new Prizes(prizeDummy);
        prizes.getRoundedTotalBenefit(cash.getDepositAmount());
        outputView.printStaticResult(prizes, cash);
    }



}






