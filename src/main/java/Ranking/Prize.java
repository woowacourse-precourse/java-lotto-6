package Ranking;

public enum Prize {
	THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_WITH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000);
	
	private final int matchCount;
	private final int prizeAmout;
	
	Prize(int matchCount, int prizeAmout){
		this.matchCount  = matchCount;
		this.prizeAmout = prizeAmout;
	}
	
	public int getMatchCount() {
		return matchCount;
	}
	
	public int getprizeAmout() {
		return prizeAmout;
	}
}
