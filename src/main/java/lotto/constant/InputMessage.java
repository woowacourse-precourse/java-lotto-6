package lotto.constant;

public enum InputMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String Message;

    InputMessage(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
