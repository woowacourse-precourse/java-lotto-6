package lotto.constant;

public enum GameMessage {

    INPUT_BUY_PRICE("구입금액을 입력해 주세요."),
    YOU_BOUGHT_N_LOTTOS("개를 구매했습니다."),
    INPUT_WIN_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("\n보너스 번호를 입력해 주세요."),
    WIN_STATISTICS("\n당첨 통계\n---"),
    MATCH_N_NUMBERS("개 일치"),
    MATCH_BONUS(", 보너스 볼 일치"),
    N_NUMBERS("개"),
    TOTAL_REVENUE_RATE_IS("총 수익률은 "),
    N_PERCENTS("%입니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
