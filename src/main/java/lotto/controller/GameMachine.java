package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.RandomLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameMachine {

    private final LottoNumbers lottoNumbers;
    private final InputView inputView;
    private final OutputView outputView;

    public GameMachine() {
        this.lottoNumbers = new RandomLottoNumbers();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        int inputPrice = inputView.inputPrice();
        int count = getCount(inputPrice);

        Lottos lottos = printLottoNumbers(count);

        Lotto winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber(winningNumbers);

        lottos.compareWithWinningNumbers(winningNumbers, bonusNumber);
        printWinningStateReturnRate(inputPrice);
    }

    private int getCount(int inputPrice) {
        return inputPrice / 1000;
    }

    private Lottos printLottoNumbers(int count) {
        outputView.lottoPurchaseCountMessage(count);
        Lottos lottos = new Lottos(count, lottoNumbers);
        outputView.lottoNumbersMessage(lottos);

        return lottos;
    }

    private void printWinningStateReturnRate(int inputPrice) {
        outputView.winningHistoryMessage();
        outputView.TotalReturnRateMessage(inputPrice);
    }

}