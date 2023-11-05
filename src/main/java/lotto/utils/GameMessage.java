package lotto.utils;

public enum GameMessage {
    REQUEST_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_WIN_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    THREE_MATCH("3개 일치"),
    FOUR_MATCH("4개 일치"),
    FIVE_MATCH("5개 일치"),
    SIX_MATCH("6개 일치"),
    BONUS_MATCH("5개 일치, 보너스 볼 일치");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
