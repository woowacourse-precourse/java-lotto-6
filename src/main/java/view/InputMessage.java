package view;

public enum InputMessage {
    INPUT_PRICE("구입금액을 입력해주세요."),
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return message;
    }
}
