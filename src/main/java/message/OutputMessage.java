package message;

public enum OutputMessage {

    PURCHASE_FINISHED_MESSAGE("개를 구매했습니다.");

    String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
