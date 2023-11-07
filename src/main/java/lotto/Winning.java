package lotto;

public enum Winning {
    FIFTH(5000, "3개 일치 (5,000원) - %d개\n"),
    FOURTH(50000, "4개 일치 (50,000원) - %d개\n"),
    THIRD(1500000, "5개 일치 (1,500,000원) - %d개\n"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST(2000000000, "6개 일치 (2,000,000,000원) - %d개\n"),
    FAIL( 0, "");

    private final int amount;
    private final String printMessage;

    Winning(int amount, String printMessage) {
        this.amount = amount;
        this.printMessage = printMessage;
    }

    public int getAmount() {
        return amount;
    }
    public String getPrintMessage() {
        return printMessage;
    }
}
