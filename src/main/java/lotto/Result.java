package lotto;

public class Result {
	public final RankEnum rank;
	public final int prize;

	public Result(RankEnum rank, int prize)        {
		this.rank = rank;
		this.prize = prize;
	}

	public RankEnum getRank() {
		return rank;
	}

	public int getPrize() {
		return prize;
	}
}
