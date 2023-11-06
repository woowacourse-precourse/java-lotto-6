package lotto;

public enum Messages {
    REQUEST_MONEY("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    ALARM_TRIAL("%d개를 구매했습니다.\n"),
    ;
    private final String message;

    Messages(String message){
        this.message = message;
    }
    @Override
    public String toString() {
        return this.message;
    }
}
