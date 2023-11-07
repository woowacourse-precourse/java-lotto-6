package lotto.config;

public enum Message {
    MONEY("구입금액을 입력해 주세요."),
    WINNING_NUM("\n당첨 번호를 입력해 주세요."),
    BONUS_NUM("\n보너스 번호를 입력해 주세요."),
    RESULT("\n당첨 통계\n---");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
