package lotto.model;

public class CountOfCorrectLotto {
    private Winning winning;
    private int count;

    public CountOfCorrectLotto(Winning winning, int count) {
        this.winning = winning;
        this.count = count;
    }

    public Integer getWinningRank() {
        return winning.getRank();
    }

    public String getWinningDescription() {
        return winning.getDescription();
    }

    public Integer getWinningPrize() {
        return winning.getPrize();
    }

    public int getCount() {
        return count;
    }
}
