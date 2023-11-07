package lotto;

import lotto.validator.InputValidator;

public class Program {
    private Customer customer = new Customer();
    private LottoTerminal lottoTerminal = new LottoTerminal();
    private InputValidator inputValidator = new InputValidator();

    private long purchaseAmount;

    public void start() {
        payMoney();
    }

    private void payMoney() {
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
