package lotto.domain;

public enum Ranking {
    FIFTH(3, "3개 일치 (5,000원)", 0, 5000),

    FOURTH(4, "4개 일치 (50,000원)", 0, 50000),

    THIRD(5, "5개 일치 (1,500,000원)", 0, 1500000),
    SECOND(-1, "5개 일치, 보너스 볼 일치 (30,000,000)원", 0, 30000000),

    FIRST(6, "6개 일치 (2,000,000,000원)", 0, 2000000000);

    private final int rank;
    private final String message;
    private final int money;
    private int count;

    Ranking(int rank, String message, int count, int money) {
        this.rank = rank;
        this.message = message;
        this.count = count;
        this.money = money;
    }

    public static void increaseRankingCount(int count) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.rank == count) {
                ranking.increaseCount();
            }
        }
    }

    public static int getTotalPrizeMoney() {
        int sum = Unit.ZERO.getValue();
        for (Ranking ranking : Ranking.values()) {
            sum += ranking.money * ranking.count;
        }
        return sum;
    }

    public void increaseCount() {
        count++;
    }

    public void decreaseCount() {
        count--;
    }

    public static void changeCountWhenHasBonusNumber() {
        Ranking.SECOND.increaseCount();
        Ranking.THIRD.decreaseCount();
    }

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }

    public int getRank(){
        return rank;
    }
}
