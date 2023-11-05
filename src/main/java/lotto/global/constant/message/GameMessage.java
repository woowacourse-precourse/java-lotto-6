package lotto.global.constant.message;

public enum GameMessage {

    INPUT_MONEY("구입금액을_입력해 주세요.")
    ,INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요.")
    ,INPUT_BONUS_NUMBERS("\n보너스 번호를 입력해 주세요.")
    ,WINNING_STATISTIC("\n당첨 통계\n---");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
