package lotto.controller;

import lotto.io.LottoIoManager;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningCalculator;
import lotto.model.WinningLottoWithBonus;

public class LottoController {

    private final LottoIoManager ioManager;

    public LottoController(LottoIoManager ioManager) {
        this.ioManager = ioManager;
    }

    public void run() {
        Money money = inputMoney();

        LottoMachine lottoMachine = new LottoMachine(money);

        displayLottos(lottoMachine);

        WinningCalculator winningCalculator = new WinningCalculator(lottoMachine.getLottos(),
                inputWinningLottoWithBonus());

        ioManager.displayWinningResult(winningCalculator.calculate());
        ioManager.displayProfitRate(winningCalculator.getProfitRate());
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
            return new Lotto(ioManager.inputLotto());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputLotto();
    }

    private int inputBonus() {
        try {
            return ioManager.inputBonus();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputBonus();
    }

    private void displayLottos(LottoMachine lottoMachine) {
        Lottos lottos = lottoMachine.getLottos();
        ioManager.displayLottosCnt(lottos.getLottos().size());
        ioManager.displayLottos(lottos);
    }

    private Money inputMoney() {
        try {
            return new Money(ioManager.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputMoney();
    }
}
