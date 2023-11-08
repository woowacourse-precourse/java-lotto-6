package lotto.constants;

public enum InputMessages {

    START_BUY_MESSAGE("구입금액을 입력해 주세요."),
    GET_WIN_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
