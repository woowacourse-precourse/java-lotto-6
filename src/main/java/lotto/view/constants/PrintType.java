package lotto.view.constants;

public enum PrintType {

    REQUEST_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    REQUEST_PRIZE_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");
    private final String Message;

    PrintType(String Message) {
        this.Message = Message;
    }

    public String getMessage() {
        return Message;
    }
}
