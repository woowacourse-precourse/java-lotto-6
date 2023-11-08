package lotto.view;

public enum RequestMessage {
    MONEY("구입금액을 입력해 주세요."),
    WINNING("\n당첨 번호를 입력해 주세요."),
    BONUS("\n보너스 번호를 입력해 주세요.");

    private String message;

    RequestMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
