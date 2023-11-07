package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    private final WinningLotto winningLotto;

    public LottoController(InputView inputView, OutputView outputView, WinningLotto winningLotto) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.winningLotto = winningLotto;
    }

    public void play() {
        Money money = createMoneyInput();
        int lottoCount = money.getLottoCount();
        outputView.printPurchase(lottoCount);
        Lottos lottos = createLottos(lottoCount);
        outputView.printLottos(lottos);
        outputView.printWinningInput();
    }

    private Money createMoneyInput() {
        outputView.printMoneyInput();
        while (true) {
            try {
                String inputMoney = inputView.moneyInput();
                return new Money(inputMoney);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lottos createLottos(int lottoCount) {
        return Lottos.generateLottos(lottoCount);
    }

    private WinningLotto createWinningLotto() {
        outputView.printWinningInput();
        Lotto winningNumbers = createWinningNumbers();
        outputView.printBonusInput();
        int bonusNumber = createBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Lotto createWinningNumbers() {
        while (true) {
            try {
                String inputWinning = inputView.winningNumbersInput();
                return winningLotto.createWinningNumbers(inputWinning);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int createBonusNumber() {
        while (true) {
            try {
                String inputBonus = inputView.bonusNumberInput();
                return winningLotto.createBonusNumber(inputBonus);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
