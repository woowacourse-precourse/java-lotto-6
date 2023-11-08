package lotto;

public enum RankEnum {

	NONE(0, 0),
	FIFTH(3, 5_000),
	FORTH(4, 50_000),
	THIRD(5, 1_500_000),
	SECOND(5, 30_000_000),
	FIRST(6, 2_000_000_000);

	private final int matchCount;
	private final int prize;


	RankEnum(int matchCount, int prize) {
		this.matchCount = matchCount;
		this.prize = prize;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrize() {
		return prize;
	}

	/**
	 * 요구사항에 명시 되어 있는 출력 값을 지키기 위해 format()을 사용하여
	 * prize를 천 단위 마다 ,로 구분하여 리턴합니다.
	 * @return
	 */
	public String getFormattedPrize() {
		return String.format("%,d", prize);
	}

	public boolean hasBonus() {
		return this == RankEnum.SECOND;
	}

	/**
	 * 로또가 맞은 개수(count)를 인자로 받고, RankEnum.values로 모든 상수와 count 값을 비교 후에
	 * 해당 개수에 맞는 등급을 리턴합니다.
	 * @param count
	 * @return 매치 횟수에 해당하는 RankEnum. 매치 횟수에 해당하는 RankEnum이 없을 경우 RankEnum.NONE을 반환합니다.
	 */
	public static RankEnum getRankByMatchCount(int count) {
		for (RankEnum rank : RankEnum.values()) {
			if (rank.matchCount == count) {
				return rank;
			}
		}
		return RankEnum.NONE;
	}
}
