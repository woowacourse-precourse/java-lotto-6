package lotto;

import lotto.validator.InputValidator;

public class Program {
    private LottoTerminal lottoTerminal = new LottoTerminal();
    private Customer customer = new Customer(lottoTerminal);
    private InputValidator inputValidator = new InputValidator();

    private long purchaseAmount;
    private String[] winningNumbers;
    private int bonusNumber;

    public void start() {
        processPayment();
        lottoTerminal.LottoIssuance();
        lottoTerminal.printAllLotto();

        processWinningNumber();
        processBonusNumber();
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
            System.out.println();
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
        winningNumbers = inputValidator.validateSeparatedByComma(value);
        inputValidator.validateOnlyNumericValues(winningNumbers);
        for (int i = 0; i < winningNumbers.length; i++) {
            inputValidator.validateNumbersInRange(winningNumbers[i]);
        }

        inputValidator.validateNoDuplicates(winningNumbers);
    }

    private void processBonusNumber() {
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println();
            String bonusNumber = lottoTerminal.requestAndReadBonusNumber();

            isValidInput = handleBonusNumber(bonusNumber);
        }
    }

    private boolean handleBonusNumber(String value) {
        try {
            validateBonusNumber(value);
            return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return false;
        }
    }

    private void validateBonusNumber(String value) {
        inputValidator.validateNonEmpty(value);
        inputValidator.validateNumericOnly(value);
        inputValidator.validateNumbersInRange(value);
    }
}
