package lotto.domain;

public enum Rank {
	RANK_1(2000000000), RANK_2(30000000), RANK_3(1500000), RANK_4(50000), RANK_5(5000), NO_RANK(0);

	private final int winning;

	Rank(int winning) {

		this.winning = winning;
	}

	public int getWinning() {
		return winning;
	}
}
