package lotto.code;

public enum PrizeType {
    FIFTH(5, 5000, "3개 일치 (($money$)원) - ($count$)개"),
    FOURTH(4, 50000, "4개 일치 (($money$)원) - ($count$)개"),
    THIRD(3, 1500000, "5개 일치 (($money$)원) - ($count$)개"),
    SECOND(2, 30000000, "5개 일치, 보너스 볼 일치 (($money$)원) - ($count$)개"),
    FIRST(1, 2000000000, "6개 일치 (($money$)원) - ($count$)개"),
    ;

    PrizeType(int prize, int prizeMoney, String message) {
        this.prize = prize;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    private int prize;
    private int prizeMoney;
    private String message;


    public int getPrize() {
        return prize;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }
}
