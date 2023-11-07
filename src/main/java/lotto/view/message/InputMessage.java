package lotto.view.message;

public enum InputMessage {

    MESSAGE_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    MESSAGE_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    MESSAGE_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String value;

    InputMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
