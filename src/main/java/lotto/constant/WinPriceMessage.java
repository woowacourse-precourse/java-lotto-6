package lotto.constant;

public enum WinPriceMessage {
    Fifth("3개 일치", 5_000, 4),
    Fourth("4개 일치", 50_000, 3),
    Third("5개 일치", 1_500_000, 2),
    Second("5개 일치, 보너스 볼 일치", 30_000_000, 1),
    First("6개 일치", 2_000_000_000, 0);


    private final String message;
    private final int prize;
    private final int index;

    WinPriceMessage(String message, int prize, int index) {
        this.message = message;
        this.prize = prize;
        this.index = index;
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }

    public int getIndex() {
        return index;
    }

}
