package lotto.controller;

import java.util.List;
import lotto.model.Budget;
import lotto.model.LottoGame;
import lotto.model.Revenue;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.RankCount;
import lotto.model.lotto.WinningLotto;
import lotto.utils.Parser;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoGame lottoGame;
    private final InputView inputView;
    private final OutputView outputView;
    private final Parser parser = new Parser();

    public LottoController(LottoGame lottoGame, InputView inputView, OutputView outputView) {
        this.lottoGame = lottoGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Budget budget = getBudget();
        LottoTicket lottoTicket = lottoGame.generateLottoTicket(budget);

        outputView.printLottoTicketCount(lottoTicket.getLottoTicketSize());
        outputView.printLottos(lottoTicket);

        WinningLotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);

        RankCount rankCount = lottoGame.calculateRankCount(lottoTicket, winningLotto, bonusNumber);
        Revenue revenue = lottoGame.calculateRevenue(rankCount, budget);

        outputView.printLottoResult(rankCount);
        outputView.printRevenue(revenue);
    }


    private Budget getBudget() {
        try {
            String inputBudget = inputView.inputBudget();
            InputValidator.validateInputBudgetType(inputBudget);
            return new Budget(Integer.parseInt(inputBudget));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBudget();
        }
    }

    private WinningLotto getWinningLotto() {
        try {
            String inputWinningNumber = inputView.inputWinningNumbers();
            InputValidator.validateInputNumbersType(inputWinningNumber);
            List<Integer> numbers = parser.parseListFromNumbers(inputWinningNumber);
            return new WinningLotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }

    }

    private BonusNumber getBonusNumber(WinningLotto winningLotto) {
        try {
            String inputBonusNumber = inputView.inputBonusNumber();
            InputValidator.validateBonusNumberType(inputBonusNumber);
            return new BonusNumber(Integer.parseInt(inputBonusNumber), winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningLotto);
        }

    }


}
