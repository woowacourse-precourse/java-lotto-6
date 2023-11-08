package lotto.controller;

import static lotto.constant.message.OutputMessage.RESULT_MESSAGE;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoMaker;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

    }

    public void run() {
        Lottos lottos = purchaseLotto();
        Lotto winningNumbers = getWinningLotto();
        WinningNumbers winningLotto = generateWinningLotto(winningNumbers);
        LottoCalculator calculator = new LottoCalculator(lottos.checkWinningResult(winningLotto));
        printPrizeResult(calculator);
    }

    private Lottos purchaseLotto() {
        while (true) {
            try {
                int money = inputView.requestMoney();
                LottoMaker lottoMaker = new LottoMaker(money);
                Lottos lottos = lottoMaker.makeLottoTickets();
                outputView.printLottoNumbers(lottos.getLotteryTicket());
                return lottos;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                return new Lotto(inputView.requestWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers generateWinningLotto(Lotto winningLotto) {
        while (true) {
            try {
                int bonusNumber = inputView.requestBonusNumber();
                return new WinningNumbers(winningLotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printPrizeResult(LottoCalculator calculator) {
        outputView.printOutputMessage(RESULT_MESSAGE);
        outputView.printPrizeResult(calculator.getResult());
        outputView.printProfitRate(calculator.calculateProfitRate());
    }

}
