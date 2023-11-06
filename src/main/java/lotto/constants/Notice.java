package lotto;

public enum Notice {
    ASK_BUDGET("구입 금액을 입력해 주세요."),
    ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    GAME_STATISTICS("당첨 통계"),
    SEPARATE_LINE("---");

    private final String message;

    Notice(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
