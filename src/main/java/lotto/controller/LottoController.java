package lotto.controller;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.view.InputHandler;
import lotto.domain.model.Lotto;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.caclulator.LottoResultCalculator;
import lotto.domain.dto.LottoResults;
import lotto.domain.model.Lottos;
import lotto.domain.model.Money;
import lotto.view.PrintMessages;
import lotto.domain.caclulator.RevenueCalculator;
import lotto.domain.model.WinningNumbers;
import lotto.domain.generator.strategy.NumberGenerationStrategy;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final Output output;
    private final LottoGenerator lottoGenerator;

    private final InputHandler inputHandler;



    public LottoController(NumberGenerationStrategy numberGenerationStrategy, Input input,
            Output output) {
        this.output = output;
        this.lottoGenerator = new LottoGenerator(numberGenerationStrategy);
        this.inputHandler = new InputHandler(input, output);
    }

    public void run() {
        Money money = inputPurchaseAmount();
        Lottos purchasedLottos = purchaseLottos(money);
        WinningNumbers winningNumbers = requestWinningNumbers();
        displayResults(purchasedLottos, winningNumbers,money);
    }

    private Money inputPurchaseAmount() {
        int amount = inputHandler.requestNumberInput(
                PrintMessages.INPUT_PURCHASE_AMOUNT.getMessage());
        return new Money(amount);
    }


    private Lottos purchaseLottos(Money money) {
        int lottoCount = money.calculateLottoCount();
        List<Lotto> lottos = generateLottos(lottoCount);
        Lottos purchasedLottos = new Lottos(lottos);
        output.printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private List<Lotto> generateLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> lottoGenerator.generateLotto())
                .collect(Collectors.toList());
    }

    private WinningNumbers requestWinningNumbers() {
        String winNumbers = inputWiningNumbers();
        int bonusNumber = inputBonusNumbers();
        return WinningNumbers.of(winNumbers, bonusNumber);
    }

    private String inputWiningNumbers() {
        return inputHandler.requestStringInput(
                PrintMessages.INPUT_WINNING_NUMBERS.getMessage());
    }

    private int inputBonusNumbers() {
        return inputHandler.requestNumberInput(
                PrintMessages.INPUT_BONUS_NUMBER.getMessage());
    }


    private void displayResults(Lottos lottos, WinningNumbers winningNumbers,Money money) {
        LottoResults results = calculateLottoResults(lottos, winningNumbers);
        printLottoResults(results,money);
    }

    private LottoResults calculateLottoResults(Lottos lottos, WinningNumbers winningNumbers) {
        return LottoResultCalculator.calculateResults(lottos, winningNumbers);
    }

    private void printLottoResults(LottoResults results,Money money) {
        output.displayInputRequest(PrintMessages.WINNING_STATISTICS.getMessage());
        output.displayInputRequest(PrintMessages.SEPARATOR.getMessage());
        output.printWinningStatistics(results);
        output.printTotalEarningsRate(calculateTotalEarningsRate(results,money));
    }

    private double calculateTotalEarningsRate(LottoResults results,Money money) {
        return RevenueCalculator.calculateRevenueRate(
                results.calculateTotalEarnings(), money);
    }
}
