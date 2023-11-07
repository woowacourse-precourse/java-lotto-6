package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.service.LottoBuyer;
import lotto.service.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Payment payment = inputView.inputPayment();
        LottoBuyer lottoBuyer = new LottoBuyer(payment);
        lottoBuyer.generateLotto();
        outputView.printLottoNumbers(lottoBuyer.getLottos());
        Lotto winningNumbers = inputView.inputWinningNumbers();
        BonusNumber bonusNumber = inputView.inputBonusNumber(winningNumbers);
        Result result = new Result(lottoBuyer);
        result.calculateResult(winningNumbers,bonusNumber);
        outputView.printWinningResult(result);
        double winningRate = result.calculateWinningRate();
        outputView.printWinningRate(winningRate);
    }


}
