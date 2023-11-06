package lotto.controller;

import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningCalculator;
import lotto.model.WinningLottoWithBonus;

public class LottoController {

    private final InputView inputView;

    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Money money = inputMoney();

        LottoMachine lottoMachine = new LottoMachine(money);

        displayLottos(lottoMachine);

        WinningCalculator winningCalculator = new WinningCalculator(lottoMachine.getLottos(),
                inputWinningLottoWithBonus());

        outputView.displayWinningResult(winningCalculator.calculate());
        outputView.displayProfitRate(winningCalculator.getProfitRate());
    }

    private WinningLottoWithBonus inputWinningLottoWithBonus() {
        Lotto lotto = inputLotto();
        int bonus = inputBonus();

        try {
            return new WinningLottoWithBonus(lotto, bonus);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputWinningLottoWithBonus();
    }

    private Lotto inputLotto() {
        try {
            return new Lotto(inputView.inputLotto());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputLotto();
    }

    private int inputBonus() {
        try {
            return inputView.inputBonus();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputBonus();
    }

    private void displayLottos(LottoMachine lottoMachine) {
        Lottos lottos = lottoMachine.getLottos();
        outputView.displayLottosCnt(lottos.getLottos().size());
        outputView.displayLottos(lottos);
    }

    private Money inputMoney() {
        try {
            return new Money(inputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputMoney();
    }
}
