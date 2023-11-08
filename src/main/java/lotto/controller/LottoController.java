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
    private final Parser parser = new Parser();
    private final InputValidator inputValidator = new InputValidator();

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


    private Budget getBudget() {
        try {
            String inputPrice = InputView.inputBudget();
            inputValidator.validateInputBudgetType(inputPrice);
            return new Budget(Integer.parseInt(inputPrice));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBudget();
        }
    }

    private WinningLotto getWinningLotto() {
        try {
            String inputWinningNumber = InputView.inputWinningNumbers();
            inputValidator.validateInputNumbersType(inputWinningNumber);
            List<Integer> numbers = parser.parseListFromNumbers(inputWinningNumber);
            return new WinningLotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }

    }

    private BonusNumber getBonusNumber(WinningLotto winningLotto) {
        try {
            String inputBonusNumber = InputView.inputBonusNumber();
            inputValidator.validateBonusNumberType(inputBonusNumber);
            return new BonusNumber(Integer.parseInt(inputBonusNumber), winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningLotto);
        }

    }


}
