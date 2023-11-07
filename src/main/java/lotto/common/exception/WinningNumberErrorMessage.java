package lotto.common.exception;

public enum WinningNumberErrorMessage {
    INVALID_WINNING_NUMBER_SIZE("당첨번호는 정해진 숫자 크기만큼 숫자가 있어야 합니다."),
    DUPLICATE_WINNING_NUMBER("당첨번호는 중복되서는 안됩니다."),
    DUPLICATE_WINNING_NUMBER_AND_BONUS("보너스번호는 중복되서는 안됩니다.");

    private final String errorMessage;

    WinningNumberErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
