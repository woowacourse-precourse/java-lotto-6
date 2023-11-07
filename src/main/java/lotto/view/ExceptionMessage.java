package lotto.view;

public enum ExceptionMessage {

    inputPurchaseAmountError("ERROR"),
    inputWinningNumbersSizeError("Error"),
    NumberFormatError("Error");


    private String errorMessage;

    private ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
