package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final LottoService lottoService;

    public Controller(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        money();
        lottos();
        winningLotto();
        result();
    }

    private void money() {
        while (true) {
            try {
                int price = InputView.inputMoney();
                OutputView.printLottoCount(lottoService.money(price));
                break;
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }

    private void lottos() {
        OutputView.print(lottoService.lottos());
    }

    private void winningLotto() {
        Lotto winningNumbers = winningNumbers();
        while (true) {
            try {
                int bonusNumber = InputView.inputBonusNumber();
                lottoService.winningLotto(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }

    private Lotto winningNumbers() {
        while (true) {
            try {
                List<Integer> numbers = InputView.inputWinningNumbers();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }

    private void result() {
        OutputView.print(lottoService.result());
        OutputView.printPercent(lottoService.percent());
    }
}
