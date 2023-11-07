package lotto.model;

public enum Rank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	NOTHING(0, 0);

	private static final String SECOND_WIN_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
	private static final String WIN_MESSAGE = "%d개 일치 (%,d원) - %d개";

	private final int match;
	private final int money;

	Rank(int match, int money) {
		this.match = match;
		this.money = money;
	}

	public int getMoney() {
		return this.money;
	}

	public String getMessage(int count) {
		if (this.equals(SECOND)) {
			return String.format(SECOND_WIN_MESSAGE, match, money, count);
		}
		return String.format(WIN_MESSAGE, match, money, count);
	}

	public static Rank getRank(int match, boolean bonus) {
		if (match == SECOND.match) {
			return isSecondWin(bonus);
		}
		return isOtherWin(match);
	}

	private static Rank isSecondWin(boolean bonus) {
		if (bonus) {
			return SECOND;
		}
		return THIRD;
	}

	private static Rank isOtherWin(int match) {
		if (FIRST.match == match)
			return FIRST;
		if (FOURTH.match == match)
			return FOURTH;
		if (FIFTH.match == match)
			return FIFTH;
		return NOTHING;
	}
}
