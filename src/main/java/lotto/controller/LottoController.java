package lotto.controller;

import lotto.model.*;
import lotto.util.RandomNumberGenerator;
import lotto.util.ResultCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoController {

    private Amount amount;
    private Lotto lotto;
    private WinningLotto winningLotto;
    private List<Result> results;
    private UserLotto userLotto;
    private Bonus bonus;

    private final RandomNumberGenerator randomNumberGenerator;
    private final ResultCalculator resultCalculator;

    public LottoController(RandomNumberGenerator randomNumberGenerator, ResultCalculator resultCalculator) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.resultCalculator = resultCalculator;
    }

    public void run() {
        enterLottoAmount();
        printLottoAmount();
        createUserLottos();
        printUserLottos();
        enterWinningLotto();
        enterBonusNumber();
        printResult();
        printProfit();
    }

    private void enterLottoAmount() {
        try {
            this.amount = new Amount(InputView.getInputAmount().trim());
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            enterLottoAmount();
        }
    }

    private void printLottoAmount() {
        OutputView.printPurchaseLottoCount(amount.getAmount());
    }

    private void enterWinningLotto() {
        try {
            List<Integer> winningLotto = Stream
                    .of(InputView.getWinningLotto().trim().split(","))
                    .map(Integer::parseInt)
                    .toList();
            this.lotto = new Lotto(winningLotto);
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            enterWinningLotto();
        }
    }

    private void createUserLottos() {
        List<Lotto> userLottos = new ArrayList<>();

        for (int i = 0; i < this.amount.getAmount(); i++) {
            List<Integer> randomNumbers = randomNumberGenerator.pickLottoNumberInRange();
            Lotto lotto = new Lotto(randomNumbers);
            userLottos.add(lotto);
        }

        this.userLotto = new UserLotto(userLottos);
    }

    private void printUserLottos() {
        OutputView.printLottos(userLotto);
    }

    private void enterBonusNumber() {
        try {
            this.bonus = new Bonus(InputView.getBonusNumber().trim(), lotto);
            this.winningLotto = new WinningLotto(lotto, bonus);
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            enterBonusNumber();
        }
    }

    private void printResult() {
        OutputView.printLottoPrizeHeader();
        results = resultCalculator.calculateWinningResults(userLotto, winningLotto);
        Rank[] ranks = Rank.values();

        for (Rank rank : ranks) {
            String description = rank.getDescription();
            long count = resultCalculator.countMatchingResults(results, rank);
            String prize = rank.getPrize();
            OutputView.printLottoPrize(description, prize, (int) count);
        }
    }

    private void printProfit() {
        double profitRatio = resultCalculator.calculateProfit(results, amount);
        OutputView.printProfit(profitRatio);
    }

}
