//Prize.java
package lotto.Enum;

public enum Prize {
	//countMatch -> matchCount
	FIFTH(3, false, 5_000),
	FOURTH(4, false, 50_000),
	THIRD(5, false, 1_500_000),
	SECOND(5, true, 30_000_000),
	FIRST(6, false, 2_000_000_000);

	private final int countMatch;
	private final boolean isMatchBonus;
	private final int prize;

	Prize(int countMatch, boolean isMatchBonus, int prize){
		this.countMatch = countMatch;
		this.isMatchBonus = isMatchBonus;
		this.prize = prize;
	}

	public int getCountMatch(){
		return this.countMatch;
	}

	public boolean getIsMatchBonus(){
		return this.isMatchBonus;
	}

	public int getPrize(){
		return this.prize;
	}

	public static Prize findPrizeByMatch(int matchCount, boolean isMatchBonus){
		for (Prize prize : values()) {
			if (prize.getCountMatch() == matchCount && prize.getIsMatchBonus() == isMatchBonus) {
				return prize;
			}
		}
		return null;
	}
}

