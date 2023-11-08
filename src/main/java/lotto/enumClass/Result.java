package lotto.enumClass;

public enum Result {

    BALL_3("3개 일치 (5,000원)", 5000, new int[]{3, 0}),
    BALL_4("4개 일치 (50,000원)", 50000, new int[]{2, 0}),
    BALL_5("5개 일치 (1,500,000원)", 1500000, new int[]{1, 0}),
    BALL_5_PLUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000, new int[]{1, 1}),
    BALL_6("6개 일치 (2,000,000,000원)", 2000000000, new int[]{0, 0});

    private final String resultMessage;
    private final long money;
    private final int[] prize;

    Result(String resultMessage, long money, int[] prize) {
        this.resultMessage = resultMessage;
        this.money = money;
        this.prize = prize;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public long getMoney() {
        return money;
    }

    public int[] getPrize() {
        return prize;
    }
}
