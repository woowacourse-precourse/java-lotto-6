package lotto.domain;

public enum Prize {

	NOTHING(0, 0),
	FIFTH(3, 5_000),
	FOURTH(4, 50_000),
	THIRD(5, 1_500_000),
	SECOND(5, 30_000_000),
	FIRST(6, 2_000_000_000);

	private final int count;
	private final int prizeMoney;

	Prize(int count, int prizeMoney) {
		this.count = count;
		this.prizeMoney = prizeMoney;
	}

	public int getCount() {
		return this.count;
	}

	public int getPrizeMoney() {
		return this.prizeMoney;
	}


	public static Prize prizeNumber(int count, boolean bouns) {
		if (count < 3) {
			return NOTHING;
		}

		if (count == 5 && bouns) {
			return SECOND;
		}

		for (Prize prize : Prize.values()) {
			if (prize.getCount() == count && prize.getCount() != 5) {
				return prize;
			}
		}
		System.out.println("[ERROR] 잘못된 결과입니다.");
		throw new IllegalArgumentException();
	}
}
