package lotto.domain;

public enum Prize {


	FIRST(6, 2000000000),
	SECOND(5, 30000000),
	THIRD(5, 1500000),
	FOURTH(4, 50000),
	FIFTH(3, 5000),
	NOTHING(0, 0);

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


	public static Prize rankNumber(int count, int bouns) {
		if (count < 3) {
			return NOTHING;
		}

		if (count == 5 && bouns == 1) {
			return SECOND;
		}

		for (Prize prize : Prize.values()){
			if(prize.getCount() == count && prize.getCount() != 5){
				return prize;
			}
		}
		System.out.println("[ERROR] 잘못된 결과입니다.");
		throw new IllegalArgumentException();
	}
}
