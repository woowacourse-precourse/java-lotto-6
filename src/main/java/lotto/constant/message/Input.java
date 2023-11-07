package lotto.constant.message;

public enum Input {
    PURCHASE("구입금액을 입력해 주세요."),
    WIN("당첨 번호를 입력해 주세요."),
    BONUMS("보너스 번호를 입력해 주세요.");

    private final String message;

    Input(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
