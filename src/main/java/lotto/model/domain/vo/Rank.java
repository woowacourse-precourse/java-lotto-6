package lotto.model.domain.vo;

public class Rank {

    private String rank;
    private Money money;
    private int headCount;

    private Rank(String rank, Money money) {
        this.rank = rank;
        this.money = money;
        this.headCount = 0;
    }

    public static Rank from(String rank, Money money) {
        return new Rank(rank, money);
    }

    public void addWinner() {
        this.headCount++;
    }

    public int getHeadCount() {
        return headCount;
    }
}
