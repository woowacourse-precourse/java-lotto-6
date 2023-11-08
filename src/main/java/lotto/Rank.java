package lotto;

public enum Rank {
	FIRST_PLACE(2000000000, 0),
	SECOND_PLACE(30000000, 0),
	THIRD_PLACE(1500000, 0),
	FOURTH_PLACE(50000, 0),
	FIFTH_PLACE(5000, 0),
	;

	private final int prizeMoney;
	private int count;

	Rank(int prizeMoney, int count) {
		this.prizeMoney = prizeMoney;
		this.count = count;
	}

	public int bePicked() {
		count++;
		return prizeMoney;
	}

	public int getCount() {
		return count;
	}
}
