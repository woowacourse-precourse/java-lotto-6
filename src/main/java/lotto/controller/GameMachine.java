package lotto.controller;

import static lotto.message.MessageConstants.ONE_THOUSAND;

import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameMachine {

    private final LottoNumberGenerator lottoNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public GameMachine() {
        this.lottoNumberGenerator = new RandomLottoNumberGenerator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        int inputPrice = inputView.inputPrice();
        int count = getCount(inputPrice);

        Lottos lottos = printLottoNumbers(count);

        Lotto winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber(winningNumbers);

        LottoBuyer lottoBuyer = new LottoBuyer();
        lottos.compareWithWinningNumbers(lottoBuyer, winningNumbers, bonusNumber);
        printWinningStateReturnRate(lottoBuyer, inputPrice);
    }

    private int getCount(int inputPrice) {
        return inputPrice / ONE_THOUSAND;
    }

    private Lottos printLottoNumbers(int count) {
        outputView.lottoPurchaseCountMessage(count);
        Lottos lottos = new Lottos(count, lottoNumberGenerator);
        outputView.lottoNumbersMessage(lottos);

        return lottos;
    }

    private void printWinningStateReturnRate(LottoBuyer lottoBuyer, int inputPrice) {
        outputView.winningHistoryMessage(lottoBuyer);
        outputView.TotalReturnRateMessage(lottoBuyer, inputPrice);
    }

}