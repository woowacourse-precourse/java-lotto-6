package lotto.controller;

import lotto.domain.*;
import lotto.util.NumberGenerator;
import lotto.util.UniqueRandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private Cash cash;
    private Lottos lottos;
    private Prizes prizes;
    private LottoMachine lottoMachine;
    private WinnerLotto winnerLotto;

    public GameController(
            InputView inputView,
            OutputView outputView,
            NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        try {
            createCashAndLottoMachine();
            purchaseLottos();
            createWinnerLotto();
            comparePurchasedLottosWithWinnerLotto();
            showStaticResult();
        } catch (IllegalStateException e) {
            outputView.printErrorMessage(e);
        }

    }

    private void createCashAndLottoMachine() {
        try {
            cash = inputView.inputCash();
            lottoMachine = new LottoMachine(numberGenerator, cash);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            createCashAndLottoMachine();
        }
    }

    private void purchaseLottos() {
        lottos = lottoMachine.purchaseLottos();
        outputView.printPurchasedLottos(lottos);
    }

    private void createWinnerLotto() {
        List<Integer> winnerNumbers = createWinnerNumbers();
        Integer bonusNumber = createBonusNumber();
        winnerLotto = new WinnerLotto(winnerNumbers, bonusNumber);
    }

    private List<Integer> createWinnerNumbers() {
        try {
            List<Integer> winnerNumbers = inputView.inputWinnerNumbers();
            return winnerNumbers;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createWinnerNumbers();
        }
    }

    private Integer createBonusNumber() {
        try {
            Integer bonusNumber = inputView.inputBonusNumber();
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createBonusNumber();
        }
    }


    private void comparePurchasedLottosWithWinnerLotto() {
        prizes = lottos.createPrizes(winnerLotto.getWinnerNumbers(),
                                    winnerLotto.getBonusNumber());
    }



    private void showStaticResult() {
        outputView.printStaticResult(prizes, cash);
        inputView.close();
    }

}
