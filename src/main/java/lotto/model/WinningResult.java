package lotto.model;

public class WinningResult {
    private final int rank;
    private final int prize;

    public WinningResult(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append(rank);
        description.append("개 일치 (");
        description.append(prize);
        description.append("원)");
        return description.toString();
    }
}
