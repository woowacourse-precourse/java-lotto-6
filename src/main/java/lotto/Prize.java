package lotto;

public enum Prize {
	FIFTH("5등", "3개 일치", 5000),
	FOURTH("4등", "4개 일치", 50000),
	THIRD("3등", "5개 일치", 1500000),
	SECOND("2등", "5개 일치, 보너스 볼 일치", 30000000),
	FIRST("1등", "6개 일치", 2000000000);

	final String rank;
	final String hitResult;
	final long money;

	Prize(String rank, String hitCount, long money) {
		this.rank = rank;
		this.hitResult = hitCount;
		this.money = money;
	}
}
