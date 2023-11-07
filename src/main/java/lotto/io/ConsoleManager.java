package lotto.io;

import static lotto.domain.statics.WinningGrade.NONE_GRADE;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.profit.ProfitRate;
import lotto.domain.purchase.PurchasePrice;
import lotto.domain.statics.WinningGrade;
import lotto.domain.statics.WinningStatics;
import lotto.domain.winning.BonusNumber;
import lotto.io.processor.InputProcessor;
import lotto.io.processor.OutputProcessor;

public class ConsoleManager {

    private final InputProcessor inputProcessor;
    private final OutputProcessor outputProcessor;

    public ConsoleManager() {
        this.inputProcessor = new InputProcessor();
        this.outputProcessor = new OutputProcessor();
    }

    public void close() {
        inputProcessor.closeConsole();
    }

    public PurchasePrice inputPurchasePrice() {
        while (true) {
            outputProcessor.printPurchasePriceHint();

            final String inputPrice = inputProcessor.inputValue();

            try {
                return new PurchasePrice(inputPrice);
            } catch (IllegalArgumentException e) {
                outputProcessor.outputErrorMessage(e);
            }
        }
    }

    public void printLottoCount(final int count) {
        outputProcessor.outputLottoCount(count);
    }

    public void printLottos(final List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            final List<Integer> numbers = lotto.getNumbers();
            outputProcessor.outputLottoNumbers(numbers);
        });
    }

    public Lotto inputWinningLottoNumbers() {
        while (true) {
            outputProcessor.outputWinningNumbersHint();

            final String inputWinningNumbers = inputProcessor.inputValue();

            try {
                return new Lotto(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                outputProcessor.outputErrorMessage(e);
            }
        }
    }

    public BonusNumber inputBonusNumber() {
        while (true) {
            try {
                outputProcessor.outputBonusNumberHint();

                final String inputBonusNumber = inputProcessor.inputValue();

                return new BonusNumber(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                outputProcessor.outputErrorMessage(e);
            }
        }
    }

    public void printStatics(final WinningStatics statics) {
        outputProcessor.outputStaticsHint();

        Arrays.stream(WinningGrade.values())
                .filter(type -> type != NONE_GRADE)
                .forEach(type -> {
                    final int count = statics.getWinningGradeCount(type);
                    outputProcessor.outputWinningStatics(type, count);
                });
    }

    public void printProfitRate(final ProfitRate profitRate) {
        outputProcessor.outputProfitRate(profitRate.getRate());
    }

}
