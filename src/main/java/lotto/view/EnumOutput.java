package lotto.view;

public enum EnumOutput {
    REQUEST_BUY_MONEY("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_NUMBER_OF_LOTTO("개를 구매했습니다.");

    private final String MESSAGE;

    EnumOutput(String message) {
        this.MESSAGE = message;
    }

    public String getMessage() {
        return MESSAGE;
    }
}
