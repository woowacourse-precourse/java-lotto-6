package lotto.constants;

public enum InputMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_TICKET_COUNT("개를 구매했습니다."),
    LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
