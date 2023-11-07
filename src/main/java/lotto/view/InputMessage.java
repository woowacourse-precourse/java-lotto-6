package lotto.view;

public enum InputMessage {

    INSERT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INSERT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INSERT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String value;

    InputMessage(String value) {
        this.value = value;
    }

    public String getMessage() {
        return value;
    }
}
