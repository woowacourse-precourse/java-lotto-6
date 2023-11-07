package lotto.model;

import static org.mockito.ArgumentMatchers.contains;

import lotto.view.OutputView;

public enum Rating {
	
	FIRST(6, 2000000000),
	SECOND(5, 30000000), //보너스번호 포함
	THIRD(5, 1500000),
	FOURTH(4, 50000),
	FIFTH(3, 5000),
	MISS(0, 0);

	private int match;
	private int reward;
	
	Rating(int match, int reward) {
		this.match = match;
		this.reward = reward;
	}
	
	OutputView outputView = new OutputView();
	
	public static Rating rating(int matchCount, boolean isContainBonus) {
		if(matchCount == SECOND.match && isContainBonus) {
			return SECOND;
		}
		if(matchCount < FIFTH.match) {
			return MISS;
		}
		throw new IllegalArgumentException();
	}
	
	public int getMatchCount() {
		return match;
	}
	
	public int getReward() {
		return reward;
	}
	
	public boolean matchCount(int match) {
		return this.match == match;
	}
}