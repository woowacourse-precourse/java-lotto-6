package lotto.controller;

import lotto.config.LottoConstants;
import lotto.model.*;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoController {

    private Amount amount;
    private Lotto lotto;
    private WinningLotto winningLotto;
    private Result result;
    private List<Result> results;
    private UserLotto userLotto;
    private Profit profit;
    private Bonus bonus;

    private final RandomNumberGenerator randomNumberGenerator;

    public LottoController(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
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
        int count = amount.calculateLottosAmount(this.amount.toString());
        OutputView.printPurchaseLottoCount(count);
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
        List<Lotto> userLottos = userLotto.getUserLotto();
        OutputView.printLottos(userLottos);
    }

    private void enterBonusNumber() {
        try {
            this.bonus = new Bonus(InputView.getBonusNumber().trim(), lotto);
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            enterBonusNumber();
        }
    }

    private void printResult() {
        OutputView.printLottoPrizeHeader();
        this.results = result.calculateWinningResults(userLotto, winningLotto);
        long firstPrizeCount = result.countMatchingResults(results, Rank.FIRST);
        long secondPrizeCount = result.countMatchingResults(results, Rank.SECOND);
        long thirdPrizeCount = result.countMatchingResults(results, Rank.THIRD);
        long fourthPrizeCount = result.countMatchingResults(results, Rank.FOURTH);
        long fifthPrizeCount = result.countMatchingResults(results, Rank.FIFTH);

        OutputView.printWinningResults(firstPrizeCount, secondPrizeCount, thirdPrizeCount, fourthPrizeCount, fifthPrizeCount);
    }

    private void printProfit() {
        double profitRatio = profit.calculateProfit(results, amount);
        OutputView.printProfit(profitRatio);
    }



}
