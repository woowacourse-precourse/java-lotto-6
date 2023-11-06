package lotto.view;

public enum OutputViewMessage {
    PAYMENT("구입금액을 입력해 주세요."),
    PURCHASED_TICKETS_COUNT("총 %d개를 구매했습니다."),
    WINNING_DRAW("당첨 번호를 입력해 주세요."),
    BONUS_DRAW("보너스 번호를 입력해 주세요.");

    private final String message;
    OutputViewMessage(String message) {
        this.message = message;
    }

    protected String getMessage() {
        return message;
    }
    protected String getFormattedMessage(Object... args){
        return String.format(message,args);
    }
}
