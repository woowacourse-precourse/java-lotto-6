package lotto.view;

public enum InputMessage {

    INPUT_LOTTO("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ;

    private final String message;

    public String getMessage() {
        return message;
    }

    InputMessage(String message) {
        this.message = message;
    }

}
