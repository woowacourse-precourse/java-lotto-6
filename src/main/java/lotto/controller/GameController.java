package lotto.controller;

import lotto.domain.*;
import lotto.util.NumberGenerator;
import lotto.util.UniqueRandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final NumberGenerator numberGenerator;

    public GameController(
            NumberGenerator numberGeneratorImp) {
        this.numberGenerator = numberGeneratorImp;
    }

    public void play() {
        try {
            gameProcess();
        } catch (IllegalStateException e) {
            outputView.printErrorMessage(e);
        }

    }

    private void gameProcess() throws IllegalStateException {
        Cash cash = depositCash();
        Lottos lottos = purchaseLotto(cash);
        Prizes prizes = compareWinnerLotto(lottos);
        outputView.printStaticResult(prizes, cash);
    }

    private Cash depositCash() throws IllegalStateException {
        try {
            return inputView.inputCash();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return depositCash();
        } catch (IllegalStateException e) {
            throw e;
        }
    }


    private Lottos purchaseLotto(Cash cash) {
        LottoMachine lottoMachine = new LottoMachine(numberGenerator, cash);
        Lottos lottos = lottoMachine.purchaseLottos();
        outputView.printPurchasedLottos(lottos);
        return lottos;
    }

    private Prizes compareWinnerLotto(Lottos lottos) throws IllegalStateException{
        try {
            List<Integer> winnerNumbers = inputView.inputWinnerNumbers();
            Integer bonusNumber = inputView.inputBonusNumber();
            inputView.close();
            WinnerLotto winnerLotto = new WinnerLotto(winnerNumbers, bonusNumber);
            Prizes prizes = lottos.createPrizes(winnerLotto);
            return prizes;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return compareWinnerLotto(lottos);
        } catch (IllegalStateException e) {
            throw e;
        }

    }



}
