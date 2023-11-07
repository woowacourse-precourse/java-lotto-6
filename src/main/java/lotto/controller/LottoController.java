package lotto.controller;

import java.util.function.Supplier;
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
        LottoMachine lottoMachine = getLottoMachine();

        displayLottos(lottoMachine.getLottos());

        WinningCalculator winningCalculator = new WinningCalculator(lottoMachine.getLottos(),
                inputWinningLottoWithBonus());

        outputView.displayWinningResult(winningCalculator.getResult());
        outputView.displayProfitRate(winningCalculator.getProfitRate());
    }

    private LottoMachine getLottoMachine() {
        return repeat(() -> {
            LottoMachine lottoMachine = new LottoMachine();
            lottoMachine.buyLottos(inputMoney());
            return lottoMachine;
        });
    }

    private Money inputMoney() {
        return new Money(inputView.inputMoney());
    }

    private WinningLottoWithBonus inputWinningLottoWithBonus() {
        Lotto lotto = repeat(this::inputLotto);
        return repeat(() -> new WinningLottoWithBonus(lotto, inputBonus()));
    }

    private Lotto inputLotto() {
        return new Lotto(inputView.inputLotto());
    }

    private int inputBonus() {
        return inputView.inputBonus();
    }

    private void displayLottos(Lottos lottos) {
        outputView.displayLottosCnt(lottos.getLottos().size());
        outputView.displayLottos(lottos);
    }

    private <T> T repeat(Supplier<T> input) {
        try {
            return input.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeat(input);
        }
    }
}
