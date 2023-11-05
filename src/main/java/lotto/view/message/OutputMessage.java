package lotto.view.message;

public enum OutputMessage {
    ASK_TO_INSERT_MONEY_FOR_LOTTO("구입금액을 입력해 주세요."),
    ASK_TO_INSERT_LOTTO_WINNING_NUMBERS("당첨 번호를 입력해 주세요.");

    private final String message;

    OutputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}