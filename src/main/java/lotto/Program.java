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

        processWinningNumber();
    }

    private void processPayment() {
        boolean isValidAmount = false;

        while (!isValidAmount) {
            String inputAmount = lottoTerminal.requestAndReadPurchaseAmount();

            isValidAmount = handlePurchaseAmount(inputAmount);
        }
        customer.expendForLotto(purchaseAmount);
    }

    private boolean handlePurchaseAmount(String inputAmount) {
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

    private void processWinningNumber() {
        boolean isValidInput = false;

        while (!isValidInput) {
            String winningNumber = lottoTerminal.requestAndReadWinningNumber();

            isValidInput = handleWinningNumber(winningNumber);
        }
    }

    private boolean handleWinningNumber(String value) {
        try {
            validateWinningNumber(value);
            return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return false;
        }
    }

    private void validateWinningNumber(String value) {
        inputValidator.validateNonEmpty(value);
        String[] winningNumbers = inputValidator.validateSeparatedByComma(value);
        inputValidator.validateOnlyNumericValues(winningNumbers);
        inputValidator.validateNumbersInRange(winningNumbers);
        inputValidator.validateNoDuplicates(winningNumbers);
    }
}
