package lotto.controller;

import lotto.domain.*;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;

public class LottoController {

    public LottoController() {
    }

    public void run() {
        Budget budget = inputBudget();
        int quantity = budget.getQuantity();
        LottoTickets lottoTickets = generateLottoTickets(quantity);

        WinningLotto winningLotto = inputWinningLotto();
        Statistic statistic = new Statistic(lottoTickets, winningLotto);
        ;
        OutputView.showLottoResult(statistic, budget);
    }

    private Budget inputBudget() {
        try {
            String budget = InputView.inputBudget();

            return new Budget(Integer.parseInt(budget));
        } catch (IllegalArgumentException error) {
            OutputView.showErrorMessage(error.getMessage());

            return inputBudget();
        }
    }

    private WinningLotto inputWinningLotto() {
        Lotto winningNumber = inputWinningNumber();

        int bonus = inputBonusNumber();

        return new WinningLotto(winningNumber, bonus);
    }

    private Lotto inputWinningNumber() {
        try {
            String winningNumber = InputView.inputWinningNumber();
            Validator.checkInputLottoNumber(winningNumber);

            return new Lotto(Arrays.stream(winningNumber.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed().toList());
        } catch (IllegalArgumentException error) {
            OutputView.showErrorMessage(error.getMessage());

            return inputWinningNumber();
        }
    }

    private int inputBonusNumber() {
        try {
            String bonusNumber = InputView.inputBonusNumber();
            return Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException error) {
            OutputView.showErrorMessage(error.getMessage());

            return inputBonusNumber();
        }
    }

    private LottoTickets generateLottoTickets(int quantity) {
        LottoTickets lottoTickets = new LottoTickets(quantity);
        OutputView.showQuantity(quantity);
        OutputView.showLottoTickets(lottoTickets);

        return lottoTickets;
    }


}
