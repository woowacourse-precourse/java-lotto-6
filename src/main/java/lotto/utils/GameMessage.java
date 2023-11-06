package lotto.utils;

public enum GameMessage {
    REQUEST_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_WIN_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n" + "---"),
    PURCHASED("개를 구매했습니다."),
    RATE_OF_RETURN("총 수익률은 "),
    IS("%입니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
