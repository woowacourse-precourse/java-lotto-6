package lotto.controller;

import lotto.domain.Rank;
import lotto.dto.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {

    private final InputView inputView;
    private final LottoService lottoService;
    private final OutputView outputView;

    public LottoGame() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
        this.outputView = new OutputView();
    }

    public void run() {
        int price = inputView.inputPrice();
        List<Lotto> lottos = purchaseLottos(price);
        printLottos(lottos);

        AnswerLotto answerLotto = receiveWinningNumbers();
        List<Rank> winningResults = evaluateWinningResults(lottos, answerLotto);

        printResults(winningResults);
        printRateOfReturn(winningResults);
    }

    private List<Lotto> purchaseLottos(int price) {
        LottoMachine lottoMachine = LottoMachine.getInstance();
        return lottoMachine.produceLottos(price);
    }

    private void printLottos(List<Lotto> lottos) {
        outputView.printLottoNumbers(lottos);
    }

    private AnswerLotto receiveWinningNumbers() {
        List<Integer> answerNumbers = inputView.inputAnswerNumbers();
        int bonusNumber = inputView.inputBonusNumber(answerNumbers);
        return new AnswerLotto(answerNumbers, bonusNumber);
    }

    private List<Rank> evaluateWinningResults(List<Lotto> lottos, AnswerLotto answerLotto) {
        return lottoService.findWinningResult(lottos, answerLotto);
    }

    private void printResults(List<Rank> winningResults) {
        outputView.printResult(winningResults);
    }

    private void printRateOfReturn(List<Rank> winningResults) {
        double rateOfReturn = lottoService.findRateOfReturn(winningResults);
        outputView.printRateOfReturn(rateOfReturn);
    }
}
