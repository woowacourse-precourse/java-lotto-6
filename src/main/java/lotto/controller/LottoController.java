package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.input.NotIntegerException;
import lotto.model.Budget;
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
import lotto.view.outputView.LottoOutputView;
import lotto.view.outputView.LottoResultOutputView;

public class LottoController {
    private final InputView inputView;
    private final LottoOutputView lottoOutputView;
    private final LottoResultOutputView lottoResultOutputView;

    public LottoController(InputView inputView, LottoOutputView lottoOutputView,
                           LottoResultOutputView lottoResultOutputView) {
        this.inputView = inputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoResultOutputView = lottoResultOutputView;
    }

    public void run() {
        Budget budget = getBudget();
        LottoMachine lottoMachine = new RandomLottoMachine();
        LottoTicket lottoTicket = new LottoTicket(budget, lottoMachine);

        lottoOutputView.printLottoTicketCount(lottoTicket.getLottoTicketSize());
        lottoOutputView.printLottos(lottoTicket);

        WinningLotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);

        LottoStrategy lottoStrategy = new MyLottoStrategy();
        RankCount rankCount = lottoStrategy.determineRankCounts(lottoTicket, winningLotto, bonusNumber);
        Revenue revenue = new Revenue(rankCount, budget);

        lottoResultOutputView.printLottoResult(rankCount);
        lottoResultOutputView.printRevenue(revenue);
    }


    public Budget getBudget() {
        try {
            String inputPrice = inputView.inputBudget();
            InputValidator.validateInputPrice(inputPrice);
            return new Budget(Integer.parseInt(inputPrice));
        } catch (NotIntegerException e) {
            System.out.println(e.getMessage());
            return getBudget(); // Recursive call for retry
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getBudget(); // Recursive call for retry
        }

    }

    public WinningLotto getWinningLotto() {

        try {
            String inputWinningNumber = inputView.inputWinningNumbers();
            List<Integer> numbers = parseListFromNumbers(inputWinningNumber);
            return new WinningLotto(numbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }

    }

    private BonusNumber getBonusNumber(WinningLotto winningLotto) {

        try {
            String inputBonusNumber = inputView.inputBonusNumber();
            InputValidator.validateBonusNumber(inputBonusNumber);
            return new BonusNumber(Integer.parseInt(inputBonusNumber), winningLotto);
        } catch (Exception e) {
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
