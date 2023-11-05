package lotto.view;

public enum OutputMessage {
    BOUGHT_LOTTO("개를 구매했습니다.");
    private String message;
    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
