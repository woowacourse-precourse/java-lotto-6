package lotto.view;

public enum ExceptionMessage {

    inputPurchaseAmountError("ERROR"),
    inputWinningNumberSizeError("Error");

    private String errorMessage;

    private ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
