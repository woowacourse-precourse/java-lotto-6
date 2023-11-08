package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Budget;
import lotto.model.LottoGame;
import lotto.model.Revenue;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.RankCount;
import lotto.model.lotto.WinningLotto;
import lotto.model.machine.LottoMachine;
import lotto.model.machine.RandomLottoMachine;
import lotto.model.strategy.LottoStrategy;
import lotto.model.strategy.MyLottoStrategy;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoGame lottoGame;

    public LottoController(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public void run() {
        Budget budget = getBudget();
        LottoTicket lottoTicket = lottoGame.generateLottoTicket(budget);

        OutputView.printLottoTicketCount(lottoTicket.getLottoTicketSize());
        OutputView.printLottos(lottoTicket);

        WinningLotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);

        RankCount rankCount = lottoGame.calculateRankCount(lottoTicket, winningLotto, bonusNumber);
        Revenue revenue = lottoGame.calculateRevenue(rankCount, budget);

        OutputView.printLottoResult(rankCount);
        OutputView.printRevenue(revenue);
    }


    public Budget getBudget() {
        try {
            String inputPrice = InputView.inputBudget();
            InputValidator.validateInputBudget(inputPrice);
            return new Budget(Integer.parseInt(inputPrice));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBudget();
        }
    }

    public WinningLotto getWinningLotto() {
        try {
            String inputWinningNumber = InputView.inputWinningNumbers();
            List<Integer> numbers = parseListFromNumbers(inputWinningNumber);
            return new WinningLotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }

    }

    private BonusNumber getBonusNumber(WinningLotto winningLotto) {

        try {
            String inputBonusNumber = InputView.inputBonusNumber();
            InputValidator.validateBonusNumber(inputBonusNumber);
            return new BonusNumber(Integer.parseInt(inputBonusNumber), winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningLotto);
        }

    }

    private List<Integer> parseListFromNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
