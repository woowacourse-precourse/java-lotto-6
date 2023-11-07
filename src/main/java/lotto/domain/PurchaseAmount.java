package lotto.domain;

public class PurchaseAmount {

    private static final String NULL = "";
    private static final String SPACE = " ";
    private static final String COMMA = ",";

    private static int amount;
    private static int numberOfLottoPurchase;

    private final ExceptionHandler exceptionHandler;

    public PurchaseAmount(String amountInput) {
        this.exceptionHandler = new ExceptionHandler();

        amountInput = removeCommas(amountInput);
        amountInput = removeSpaces(amountInput);
        validateInputAmount(amountInput);
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return numberOfLottoPurchase;
    }


    private String removeCommas(String amount) {
        return amount.replace(COMMA, NULL);
    }

    private String removeSpaces(String amount) {
        return amount.replace(SPACE, NULL);
    }

    private void validateInputAmount(String amount) {
        try {
            exceptionHandler.checkNotNull(amount);
            exceptionHandler.checkInteger(amount);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}