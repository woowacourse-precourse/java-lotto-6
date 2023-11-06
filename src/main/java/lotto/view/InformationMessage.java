package lotto.view;

public enum InformationMessage {
    PURCHASE("개를 구매했습니다.");


    private String message;

    InformationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
