package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoFactory;
import lotto.model.Lottos;
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
        outputView.printInputWinningNumbersSentence();
        List<Integer> winningNumbers = inputView.inputLottoNumbers();

        outputView.printInputBonusNumberSentence();
        Integer bonusNumber = inputView.inputNumber();
        return lottoFactory.createWinningLotto(winningNumbers, bonusNumber);
    }
}
