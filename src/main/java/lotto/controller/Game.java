package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.number.DrawnNumbers;
import lotto.domain.number.Lotto;
import lotto.domain.number.Lottos;
import lotto.domain.number.Number;
import lotto.domain.purchase.LottoGenerator;
import lotto.domain.purchase.PurchaseAmount;
import lotto.domain.winning.WinningStatistics;
import lotto.ui.InputReader;
import lotto.ui.OutputWriter;

public class Game {
    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public Game(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void start() {
        PurchaseAmount purchaseAmount = inputUntilValid(this::inputPurchaseAmount);

        Lottos lottos = lottoGenerator.generateAutomaticallyBy(purchaseAmount);
        outputWriter.writeLottos(lottos);

        Lotto winningNumbers = inputUntilValid(this::inputWinningNumbers);

        DrawnNumbers drawnNumbers = inputUntilValid(() -> {
            Number bonusNumber = inputBonusNumber();
            return new DrawnNumbers(winningNumbers, bonusNumber);
        });

        WinningStatistics winningStatistics = WinningStatistics.of(lottos, drawnNumbers);
        outputWriter.writeWinningStatistics(winningStatistics);
    }

    private <T> T inputUntilValid(Supplier<T> inputMethod) {
        while (true) {
            try {
                return inputMethod.get();
            } catch (IllegalArgumentException e) {
                outputWriter.writeError(e);
            }
        }
    }

    private PurchaseAmount inputPurchaseAmount() {
        outputWriter.writePurchaseAmountInput();
        return inputReader.readPurchaseAmount();
    }

    private Lotto inputWinningNumbers() {
        outputWriter.writeWinningNumbersInput();
        return inputReader.readWinningNumbers();
    }

    private Number inputBonusNumber() {
        outputWriter.writeBonusNumberInput();
        return inputReader.readBonusNumber();
    }
}
