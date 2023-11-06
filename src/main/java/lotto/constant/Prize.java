package lotto.constant;

public enum Prize {
	FIFTH("3개 일치", 5000),
	FOURTH("4개 일치", 50000),
	THIRD("5개 일치", 1500000),
	SECOND("5개 일치, 보너스 볼 일치", 30000000),
	FIRST("6개 일치", 2000000000);

	private final String hitResult;
	private final long money;

	Prize(String hitCount, long money) {

		this.hitResult = hitCount;
		this.money = money;
	}

	public String getHitResult() {
		return hitResult;
	}

	public long getMoney() {
		return money;
	}
}
