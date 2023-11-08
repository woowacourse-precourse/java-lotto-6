package lotto.constant;

public enum GameMessage {

    INPUT_BUY_PRICE("구입금액을 입력해 주세요."),
    YOU_BOUGHT_N_LOTTOS("개를 구매했습니다."),
    INPUT_WIN_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    WIN_STATISTICS("당첨 통계\n---");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
