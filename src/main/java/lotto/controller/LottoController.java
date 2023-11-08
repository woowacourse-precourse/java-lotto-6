package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoFactory;
import lotto.model.Lottos;
import lotto.model.RankCounter;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final LottoFactory lottoFactory = new LottoFactory();

    public Lottos purchaseLottos(int numberOfLotto) {
        outputView.printOutputNumberOfPurchaseLotto(numberOfLotto);
        Lottos lottos = lottoFactory.createLottos(numberOfLotto);
        outputView.printLottos(lottos.toString());
        return lottos;
    }

    public WinningLotto createWinningLotto() {
        try {
            List<Integer> winningNumbers = inputWinningNumbers();
            outputView.printNewLine();

            Integer bonusNumber = inputBonusNumber();
            outputView.printNewLine();
            return lottoFactory.createWinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return createWinningLotto();
        }
    }

    private List<Integer> inputWinningNumbers() {
        try {
            outputView.printInputWinningNumbersSentence();
            List<Integer> winningNumbers = inputView.inputLottoNumbers();
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private Integer inputBonusNumber() {
        try {
            outputView.printInputBonusNumberSentence();
            Integer bonusNumber = inputView.inputNumber();
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return inputBonusNumber();
        }
    }

    public void getLottosResult(Lottos lottos, WinningLotto winningLotto) {
        outputView.printOutputWinningStatisticsSentence();
        outputView.printOutputContour();
        RankCounter rankCounter = lottos.getResults(winningLotto);
        outputView.print(rankCounter.toString());
        outputView.printOutputEarningRate(rankCounter.computeBenefit(lottos.size()));
    }
}
