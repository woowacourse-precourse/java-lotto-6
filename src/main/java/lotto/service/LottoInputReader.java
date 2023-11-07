package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.io.read.InputReader;
import lotto.io.write.OutputWriter;
import lotto.validation.LottoValidator;

public class LottoInputReader {

    private final InputReader reader;
    private final LottoValidator validator;

    public LottoInputReader(InputReader reader, LottoValidator validator) {
        this.reader = reader;
        this.validator = validator;
    }

    public int readPurchaseAmount() {
        OutputWriter.showPurchaseAmountInputMessage();

        while (true) {
            try {
                String purchaseAmountInput = reader.readLine();
                ensurePurchaseAmountIsValid(purchaseAmountInput);

                return Integer.parseInt(purchaseAmountInput);

            } catch (IllegalArgumentException ex) {
                OutputWriter.showExceptionMessage(ex.getMessage());
            }
        }
    }

    public List<Integer> readWinNumbers() {
        OutputWriter.showLottoWinNumbersInputMessage();

        while (true) {
            try {
                String winNumbersInput = reader.readLine();
                ensureWinNumbersIsValid(winNumbersInput);

                return Arrays.stream(winNumbersInput.split(","))
                        .map(it -> Integer.parseInt(it.trim()))
                        .sorted()
                        .toList();

            } catch (IllegalArgumentException ex) {
                OutputWriter.showExceptionMessage(ex.getMessage());
            }
        }
    }

    private void ensureWinNumbersIsValid(String winNumbersInput) {
        validator.verifyWinNumbers(winNumbersInput);
    }

    private void ensurePurchaseAmountIsValid(String purchaseAmountInput) {
        validator.verifyPurchaseAmount(purchaseAmountInput);
    }
}
