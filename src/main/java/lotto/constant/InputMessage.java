package lotto.constant;

public enum InputMessage {
    REQUEST_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INFORM_QUANTITY_MESSAGE("개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String inputMessage;

    private InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getMessage() {
        return inputMessage;
    }
}
