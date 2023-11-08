package lotto.common;


public enum ExceptionMessage {
    MONEY_SHOULD_BE_POSITIVE_OR_ZERO("money는 0보다 크거나 같아야 합니다.");
    private String message = "[ERROR]";

    ExceptionMessage(String addedMessage) {
        this.message += addedMessage;
    }
}
