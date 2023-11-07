package lotto.constant.message;

public enum InputMessage {
    INPUT_PURCHASE("구매금액을 입력해 주세요."),
    INPUT_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS("\n보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
