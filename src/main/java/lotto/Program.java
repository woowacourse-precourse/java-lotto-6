package lotto;

import lotto.validator.InputValidator;

public class Program {
    private LottoTerminal lottoTerminal = new LottoTerminal();
    private Customer customer = new Customer(lottoTerminal);
    private InputValidator inputValidator = new InputValidator();

    private long purchaseAmount;

    public void start() {
        processPayment();
        lottoTerminal.LottoIssuance();
        lottoTerminal.printAllLotto();
    }

    private void processPayment() {
        boolean isValidAmount = false;

        while (!isValidAmount) {
            isValidAmount = handlePurchaseAmount();
        }
        customer.expendForLotto(purchaseAmount);
    }

    private boolean handlePurchaseAmount() {
        String inputAmount = lottoTerminal.requestAndReadPurchaseAmount();

        try {
            validatePurchaseAmount(inputAmount);
            purchaseAmount = Long.parseLong(inputAmount);
            return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return false;
        }
    }

    private void validatePurchaseAmount(String value) {
        inputValidator.validateNonEmpty(value);
        inputValidator.validateNonZeroAmount(value);
        inputValidator.validateOnlyNumeric(value);
        inputValidator.validateLongValueRange(value);
        inputValidator.validateAmountDivisibility(value);
    }
}
