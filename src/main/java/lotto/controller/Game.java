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
        PurchaseAmount purchaseAmount = callback(this::inputPurchaseAmount);

        Lottos lottos = lottoGenerator.generateAutomaticallyBy(purchaseAmount);
        outputWriter.writeLottos(lottos);

        Lotto winningNumbers = callback(this::inputWinningNumbers);

        DrawnNumbers drawnNumbers = callback(() -> {
            Number bonusNumber = inputBonusNumber();
            return new DrawnNumbers(winningNumbers, bonusNumber);
        });

        WinningStatistics winningStatistics = WinningStatistics.of(lottos, drawnNumbers);
        outputWriter.writeWinningStatistics(winningStatistics);
    }

    // TODO: 메서드 이름 명확하게 바꾸기
    private <T> T callback(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
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
