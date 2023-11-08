package lotto.controller;

import lotto.domain.*;
import lotto.generator.lotto.LottoNumbersGenerator;
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
        LottoMachine lottoMachine = new LottoMachine(new LottoNumbersGenerator());

        Lottos lottos = buyLottos(lottoMachine);
        outputView.printLottos(lottos);

        WinningLotto winningLotto = createWinningLotto();

        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        lottoResult.makeResult();
        outputView.printLottoResult(lottoResult);
    }

    private Lottos buyLottos(LottoMachine lottoMachine) {
        while (true) {
            try {
                int money = inputView.inputMoney();
                return lottoMachine.buyLottos(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto createWinningLotto() {
        Lotto winnerLotto = getWinnerLotto();

        while (true) {
            try {
                BonusBall bonusBall = getBonusBall();
                return new WinningLotto(winnerLotto, bonusBall);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinnerLotto() {
        while (true) {
            try {
                return new Lotto(inputView.inputWinningLotto());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusBall getBonusBall() {
        while (true) {
            try {
                return new BonusBall(inputView.inputBonusBall());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
