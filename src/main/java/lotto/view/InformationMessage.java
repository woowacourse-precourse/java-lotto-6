package lotto.view;

public enum InformationMessage {
    PURCHASE("개를 구매했습니다."),
    STATISTICS("\n당첨 통계\n" + "---"),
    FIFTH_PLACE("3개 일치 (5,000원) - %d개\n"),
    FOURTH_PLACE("4개 일치 (50,000원) - %d개\n"),
    THIRD_PLACE("5개 일치 (1,500,000원) - %d개\n"),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST_PLACE("6개 일치 (2,000,000,000원) - %d개\n"),
    RATE_OF_RETURN("총 수익률은 %s%%입니다.");


    private String message;

    InformationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
