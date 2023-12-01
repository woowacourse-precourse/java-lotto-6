package lotto.view;


public enum Format {

    PRICE("%s원"),
    PURCHASE_LOTTO("%d개를 구매했습니다."),
    RESULT_OF_FIRST("6개 일치 (2,000,000,000원) - %d개"),
    RESULT_OF_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    RESULT_OF_THIRD("5개 일치 (1,500,000원) - %d개"),
    RESULT_OF_FORTH("4개 일치 (50,000원) - %d개"),
    RESULT_OF_FIFTH("3개 일치 (5,000원) - %d개"),
    EARNING_RATE("총 수익률은 %s%%입니다."),
    ;


    private final String format;

    Format(final String format) {
        this.format = format;
    }

    public void print(Object... args) {
        System.out.printf((format) + "\n", args);
    }
}
