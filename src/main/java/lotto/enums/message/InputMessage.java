package lotto.enums.message;

public enum InputMessage {
    BUY_INPUT("구입금액을 입력해 주세요.")
    , WINNING_INPUT("당첨 번호를 입력해 주세요.")
    , BONUS_INPUT("보너스 번호를 입력해 주세요.")
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
