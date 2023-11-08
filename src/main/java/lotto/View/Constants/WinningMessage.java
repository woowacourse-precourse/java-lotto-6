package lotto.View.Constants;

public enum WinningMessage {
    THREE_CORRECT ("3개 일치 (5,000원) - %d개"),
    FOUR_CORRECT ("4개 일치 (50,000원) - %d개"),
    FIVE_CORRECT ("5개 일치 (1,500,000원) - %d개"),
    FIVE_CORRECT_AND_LUCKY_NUM ("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_CORRECT ("6개 일치 (2,000,000,000원) - %d개"),


    ROI ("총 수익률은 %s%%입니다.");


    private final String message;

    WinningMessage(String message) {
        this.message = message;
    }

    public String formMessage(int quantity){
        return String.format(message, quantity);
    }

    public String formOutput(String output) {
        return String.format(message, output);
    }

}
