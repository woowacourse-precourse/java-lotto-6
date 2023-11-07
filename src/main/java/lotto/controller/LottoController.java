package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.service.LottoMachine;
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
        LottoMachine lottoMachine = new LottoMachine(payment);
        printLottoNumbers(lottoMachine);

        Lotto winningNumbers = inputView.inputWinningNumbers();
        BonusNumber bonusNumber = inputView.inputBonusNumber(winningNumbers);
        Result result = calculateResult(lottoMachine, winningNumbers, bonusNumber);

        printResult(result);
    }

    private void printLottoNumbers(LottoMachine lottoMachine) {
        lottoMachine.generateLotto();
        outputView.printLottoNumbers(lottoMachine.getLottos());
    }

    private Result calculateResult(LottoMachine lottoMachine, Lotto winningNumbers, BonusNumber bonusNumber) {
        Result result = new Result(lottoMachine);
        result.calculateResult(winningNumbers, bonusNumber);
        return result;
    }

    private void printResult(Result result) {
        outputView.printWinningResult(result);
        double winningRate = result.calculateWinningRate();
        outputView.printWinningRate(winningRate);
    }


}
