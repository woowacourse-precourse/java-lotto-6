package enums;

public enum ExceptionMessage {
    ILLIGAL_ARGUMENT_ERROR_MESSAGE("[ERROR] 잘못된 로또 금액 입니다.");

    private final String exceptMessage;
    ExceptionMessage(String message) {
        this.exceptMessage = message;
    }
    public String getMessage(){
        return exceptMessage;
    }
}
