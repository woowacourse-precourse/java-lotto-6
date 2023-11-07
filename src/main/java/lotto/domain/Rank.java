package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
	ZERO_LOSE(0, 0L, "0"),
	ONE_LOSE(1, 0L, "0"),
	TWO_LOSE(2, 0L, "0"),
	FIFTH(3, 5_000L, "5,000"),
	FOURTH(4, 50_000L, "50,000"),
	THIRD(5, 1_500_000L, "1,500,000"),
	SECOND(5, 30_000_000L, "30,000,000"),
	FIRST(6, 2_000_000_000L, "2,000,000,000");
	
	private final int standardCount;
	private final Long prize;
	private final String prizeText;
	private static final int DEFINITE_SIZE = 1;

	Rank(int standardCount, long prize, String prizeText) {
		this.standardCount = standardCount;
		this.prize = prize;
		this.prizeText = prizeText;
	}
	
	public static Rank ranking(int correctCount, boolean correctBonusNumber) {
		List<Rank> applyRanks = Arrays.stream(values()).filter(rank -> rank.getCount() == correctCount)
				.collect(Collectors.toList());
		if (applyRanks.size() != DEFINITE_SIZE) {
			return isSecondOrThird(correctBonusNumber);
		}
		return applyRanks.get(0);
    }
	
	public static Rank isSecondOrThird(boolean correctBonusNumber) {
		if (correctBonusNumber) {
			return SECOND;
		}
		return THIRD;
	}
	
	public int getCount() {
		return standardCount;
	}
	
	public Long getPrize() {
		return prize;
	}
	
	public String getPrizeText() {
		return prizeText;
	}

	
}
