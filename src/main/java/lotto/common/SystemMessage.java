package lotto.common;

public enum SystemMessage {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    OUTPUT_MONEY_MESSAGE("%d개를 구매했습니다."),
    INPUT_WINNING_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    OUTPUT_WIN_MESSAGE("당첨통계"+"\n"+"---"),
    OUTPUT_RESULT_MESSAGE("%d개 일치 (%s원) - %d개"),
    OUTPUT_SECOND_RESULT_MESSAGE("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    OUTPUT_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    SystemMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
