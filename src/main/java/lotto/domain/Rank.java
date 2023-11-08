package lotto.domain;

import java.util.Arrays;

public enum Rank {

	FIRST(6, 2000000000), 
	SECOND(5, 30000000), 
	THIRD(5, 1500000), 
	FOURTH(4, 50000), 
	FIFTH(3, 5000), 
	MISS(0, 0);

	private final int matchCount;
	private final int reward;

	Rank(int matchCount, int reward) {
		this.matchCount = matchCount;
		this.reward = reward;
	}

	public static Rank getRank(int matchCount, boolean containBonusNumber) {
		if (matchCount == THIRD.matchCount && !containBonusNumber) {
			return THIRD;
		}

		if (matchCount < FIFTH.matchCount) {
			return MISS;
		}

		return Arrays.stream(Rank.values())
				.filter(Rank -> Rank.matchCount == matchCount) // 3등과 미쓰 빼고 나머지는 매치카운트와 동일
				.findAny() // 여러개 있을 수 있으므로 그중 임의의 하나 뽑기
				.orElse(Rank.MISS); // 아무것도 해당안되면 미쓰
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getReward() {
		return reward;
	}
}