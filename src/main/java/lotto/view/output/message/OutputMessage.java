package lotto.view.output.message;

public enum OutputMessage {

    READ_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    READ_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    READ_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),

    PRINT_PURCHASED_LOTTOS_MESSAGE("%d개를 구매했습니다.");


    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
