package lotto.Message;

public enum OutputPrompt {

    WHITE_SPACE(" "),
    HOW_MANY_LOTTERY_ARE_BOUGHT("%d개를 구매했습니다."),
    LOTTO_GAME_RESULT_NOTICE("\n당첨 통계\n---");
    private String message;

    OutputPrompt(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
