package lotto.controller;

import static lotto.constant.message.OutputMessage.RESULT_MESSAGE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoMaker;
import lotto.domain.PrizeResult;
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
        List<Lotto> tickets = makeLotteries();
        Lotto winningLotto = getWinningLotto();
        WinningNumbers winningNumbers = generateWinningNumbers(winningLotto);
        PrizeResult prizeResult = new PrizeResult(winningNumbers, tickets);
        LottoCalculator calculator = new LottoCalculator(prizeResult.getWinningResult());
        printPrizeResult(calculator);
    }

    private List<Lotto> makeLotteries() {
        while (true) {
            try {
                int money = inputView.requestMoney();
                LottoMaker lottoMaker = new LottoMaker(money);
                List<Lotto> lottoTickets = lottoMaker.makeLottoTickets();
                outputView.printLottoNumbers(lottoTickets);
                return lottoTickets;
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

    private WinningNumbers generateWinningNumbers(Lotto winningLotto) {
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
