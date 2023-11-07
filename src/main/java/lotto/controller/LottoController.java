package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    public LottoController(final NumberGenerator numberGenerator, final Calculator calculator) {
        this.numberGenerator = numberGenerator;
        this.calculator = calculator;
    }

    public void start() {
        Money money = getValidMoneyInput();
        int ticketCount = money.calculateTicketCount();
        OutputView.printTicketCount(ticketCount);
        List<Lotto> userLottos = generateUserLottos(ticketCount);
        OutputView.printUserLottos(userLottos);
        WinningNumbers winningNumbers = getValidWinningNumbersInput();
        BonusNumber bonusNumber = getValidBonusNumberInput(winningNumbers);
        Map<Rank, Integer> rankCount = calculator.calculateRankCount(userLottos, winningNumbers, bonusNumber);
        OutputView.printWinningStatistics();
        OutputView.printRankCount(rankCount);
        printRateOfReturn(rankCount, money);
    }

    private <T> T getValidInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
    }

    private Money getValidMoneyInput() {
        return getValidInput(() -> new Money(InputView.getMoneyInput()));
    }

    private List<Lotto> generateUserLottos(int ticketCount) {
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> generateValidLotto())
                .collect(Collectors.toList());
    }


    private Lotto generateValidLotto() {
        return getValidInput(() -> new Lotto(numberGenerator.createRandomLottoNumbers()));
    }

    private WinningNumbers getValidWinningNumbersInput() {
        return getValidInput(() -> new WinningNumbers(InputView.getWinningNumbersInput()));
    }

    private BonusNumber getValidBonusNumberInput(WinningNumbers winningNumbers) {
        return getValidInput(() -> new BonusNumber(InputView.getBonusNumberInput(), winningNumbers));
    }

    private void printRateOfReturn(Map<Rank, Integer> rankCount, Money money) {
        int totalPrize = calculator.calculateTotalPrize(rankCount);
        double rateOfReturn = calculator.calculateRateOfReturn(totalPrize, money);
        OutputView.printRateOfReturn(rateOfReturn);
    }
}