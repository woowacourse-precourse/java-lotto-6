package lotto.common;

public enum SystemMessage {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    OUTPUT_MONEY_MESSAGE("%d개를 구매했습니다."),
    INPUT_WINNING_LOTTO_NUMBERS("당첨 번호를 입력해 주세요.");

    private final String message;

    SystemMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
