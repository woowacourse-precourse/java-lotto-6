package lotto.view.message.view;

public enum ResultMessage {
    START_TO_SHOW_STATISTICS("\n당첨 통계\n---\n"),
    MATCHES_3_NUMBERS("3개 일치 (5,000원) - %d개\n"),
    MATCHES_4_NUMBERS("4개 일치 (50,000원) - %d개\n"),
    MATCHES_5_NUMBERS("5개 일치 (1,500,000원) - %d개\n"),
    MATCHES_5_NUMBERS_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    MATCHES_6_NUMBERS("6개 일치 (2,000,000,000원) - %d개\n"),
    PROFIT_PERCENT("총 수익률은 %.1f%%입니다.");

    private final String message;

    ResultMessage(String message){
        this.message =message;
    }

    public String getMessage() {
        return message;
    }

    public void displayMessage(){
        System.out.println(message);
    }
}
