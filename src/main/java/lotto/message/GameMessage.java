package lotto.message;

public enum GameMessage implements Message {

    ASK_FOR_PURCHASE_COST("구입금액을 입력해 주세요."),
    ASK_FOR_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_FOR_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
