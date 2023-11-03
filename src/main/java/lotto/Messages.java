package lotto;

public enum Messages {
    REQUEST_MONEY("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
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
