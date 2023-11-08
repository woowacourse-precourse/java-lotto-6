package lotto.constants;

public enum InputMessage {

    PURCHASE_PRICE("구입 금액을 입력해 주세요."),
    LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String description) {
        this.message = description;
    }

    @Override
    public String toString() {
        return message;
    }
}
