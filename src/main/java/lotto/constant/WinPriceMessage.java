package lotto.constant;

public enum WinPriceMessage {
    First("6개 일치", 2_000_000_000),
    Second("5개 일치, 보너스 볼 일치", 30_000_000),
    Third("5개 일치", 1_500_000),
    Fourth("4개 일치", 50_000),
    Fifth("3개 일치", 5_000);


    private final String message;
    private final int prize;

    WinPriceMessage(String message, int prize) {
        this.message = message;
        this.prize = prize;
    }

    public String getMessage() {
        return message;
    }
    public int getPrize(){
        return prize;
    }

}
