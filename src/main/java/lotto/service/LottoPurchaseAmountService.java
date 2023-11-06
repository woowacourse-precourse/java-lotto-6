package lotto.service;

import lotto.exception.ExceptionMessageWriter;
import lotto.io.read.InputReader;
import lotto.io.write.LottoOutputWriter;
import lotto.service.validation.LottoValidator;

public class LottoPurchaseAmountService {

    private InputReader reader;
    private LottoValidator validator;

    public LottoPurchaseAmountService(InputReader reader, LottoValidator validator) {
        this.reader = reader;
        this.validator = validator;
    }

    public int readLottoPurchaseAmount() {
        LottoOutputWriter.showPurchaseAmountMessage();

        while (true) {
            try {
                String purchaseAmountInput = reader.readLine();
                ensureValidPurchaseAmount(purchaseAmountInput);

                return Integer.parseInt(purchaseAmountInput);

            } catch (IllegalArgumentException ex) {
                ExceptionMessageWriter.showExceptionMessage(ex.getMessage());
            }
        }
    }

    private void ensureValidPurchaseAmount(String purchaseAmountInput) {
        validator.verifyPurchaseAmount(purchaseAmountInput);
    }
}
