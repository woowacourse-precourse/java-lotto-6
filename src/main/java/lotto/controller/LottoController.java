package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.NumberGenerator;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final NumberGenerator numberGenerator;
    private final Calculator calculator;

    public LottoController() {
        this.numberGenerator = new NumberGenerator();
        this.calculator = new Calculator();
    }

    public void start() {
        Money money = getMoneyInputAndPrintTicketCount();
        List<Lotto> userLottos = createLottosAndPrintThem(money);
        WinningNumbers winningNumbers = getValidWinningNumbersInput();
        BonusNumber bonusNumber = getValidBonusNumberInput(winningNumbers);
        Map<Rank, Integer> rankCount = calculateRankCount(userLottos, winningNumbers, bonusNumber);
        printRankCountAndEarningRate(rankCount, money);
    }

    private Money getMoneyInputAndPrintTicketCount() {
        Money money = getValidMoneyInput();
        int ticketCount = money.calculateTicketCount();
        OutputView.printTicketCount(ticketCount);
        return money;
    }

    private List<Lotto> createLottosAndPrintThem(Money money) {
        int ticketCount = money.calculateTicketCount();
        List<Lotto> userLottos = createLottos(ticketCount);
        OutputView.printUserLottos(userLottos);
        return userLottos;
    }

    private WinningNumbers getValidWinningNumbersInput() {
        WinningNumbers winningNumbers;
        while (true) {
            try {
                List<Integer> numbers = InputView.getWinningNumbersInput();
                winningNumbers = new WinningNumbers(numbers);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
        return winningNumbers;
    }

    private BonusNumber getValidBonusNumberInput(WinningNumbers winningNumbers) {
        BonusNumber bonusNumber;
        while (true) {
            try {
                int number = InputView.getBonusNumberInput();
                bonusNumber = new BonusNumber(number, winningNumbers.getWinningNumbers());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
        return bonusNumber;
    }

    private Map<Rank, Integer> calculateRankCount(List<Lotto> userLottos, WinningNumbers winningNumbers,
                                                  BonusNumber bonusNumber) {
        return calculator.calculateRankCount(userLottos, winningNumbers, bonusNumber);
    }

    private void printRankCountAndEarningRate(Map<Rank, Integer> rankCount, Money money) {
        OutputView.printRankCount(rankCount);
        int totalPrize = calculator.calculateTotalPrize(rankCount);
        double earningRate = calculator.calculateEarningRate(totalPrize, money);
        OutputView.printEarningRate(earningRate);
    }

    private Money getValidMoneyInput() {
        Money money;
        while (true) {
            try {
                int amount = InputView.getMoneyInput();
                money = new Money(amount);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
        return money;
    }

    private List<Lotto> createLottos(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = createValidLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto createValidLotto() {
        Lotto lotto;
        while (true) {
            try {
                List<Integer> lottoNumbers = numberGenerator.createRandomLottoNumbers();
                lotto = new Lotto(lottoNumbers);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
        return lotto;
    }
}