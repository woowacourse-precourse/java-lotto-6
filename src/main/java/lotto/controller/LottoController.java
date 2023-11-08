package lotto.controller;


import static lotto.domain.LottoConfig.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.model.Lotto;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.caclulator.LottoResultCalculator;
import lotto.domain.dto.LottoResults;
import lotto.domain.model.Lottos;
import lotto.domain.model.Money;
import lotto.util.InputFormatter;
import lotto.util.InputValidator;
import lotto.view.PrintMessages;
import lotto.domain.caclulator.RevenueCalculator;
import lotto.domain.model.WinningNumbers;
import lotto.domain.generator.strategy.NumberGenerationStrategy;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final Output output;

    private final Input input;
    private final LottoGenerator lottoGenerator;


    public LottoController(NumberGenerationStrategy numberGenerationStrategy, Input input,
            Output output) {
        this.output = output;
        this.input = input;
        this.lottoGenerator = new LottoGenerator(numberGenerationStrategy);
    }

    public void run() {
        Money money = inputPurchaseAmount();
        Lottos purchasedLottos = purchaseLottos(money);
        WinningNumbers winningNumbers = requestWinningNumbers();
        LottoResults results = calculateLottoResults(purchasedLottos, winningNumbers);
        displayResults(results, money);
    }

    private Money inputPurchaseAmount() {
        output.displayInputRequest(PrintMessages.INPUT_PURCHASE_AMOUNT.getMessage());
        while (true) {
            try {
                int amount = input.inputNumber();
                return new Money(amount);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    private Lottos purchaseLottos(Money money) {
        int lottoCount = money.calculateLottoCount();
        List<Lotto> lottos = generateLottos(lottoCount);
        Lottos purchasedLottos = new Lottos(lottos);
        output.printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private List<Lotto> generateLottos(int count) {
        return IntStream.range(ZERO.getValue(), count)
                .mapToObj(i -> lottoGenerator.generateLotto())
                .collect(Collectors.toList());
    }

    private WinningNumbers requestWinningNumbers() {
        output.displayInputRequest(PrintMessages.INPUT_WINNING_NUMBERS.getMessage());
        Lotto winNumbers = inputWinningNumbers();
        return createWinningNumbers(winNumbers);
    }

    private Lotto inputWinningNumbers() {
        while (true) {
            try {
                String winNumber = input.inputString();
                InputValidator.validateWinningNumbers(winNumber);
                List<Integer> formatWinNumber = InputFormatter.formatWinningNumber(winNumber);
                return new Lotto(formatWinNumber);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    private WinningNumbers createWinningNumbers(Lotto winNumbers) {
        output.displayInputRequest(PrintMessages.INPUT_BONUS_NUMBER.getMessage());
        while (true) {
            try {
                int bonusNumber = input.inputNumber();
                return new WinningNumbers(winNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    private LottoResults calculateLottoResults(Lottos lottos, WinningNumbers winningNumbers) {
        return LottoResultCalculator.calculateResults(lottos, winningNumbers);
    }

    private void displayResults(LottoResults results, Money money) {
        printLottoResults(results, money);
    }

    private void printLottoResults(LottoResults results, Money money) {
        output.displayInputRequest(PrintMessages.WINNING_STATISTICS.getMessage());
        output.displayInputRequest(PrintMessages.SEPARATOR.getMessage());
        output.printWinningStatistics(results);
        output.printTotalEarningsRate(calculateTotalEarningsRate(results, money));
    }

    private double calculateTotalEarningsRate(LottoResults results, Money money) {
        return RevenueCalculator.calculateRevenueRate(
                results.calculateTotalEarnings(), money);
    }
}
