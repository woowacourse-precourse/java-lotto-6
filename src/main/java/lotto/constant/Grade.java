package lotto.constant;

import static lotto.view.constant.OutputConstant.*;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Grade {
	FIFTH(5, 3, 5_000),
	FOURTH(4, 4, 50_000),
	THIRD(3, 5, 1_500_000),
	SECOND(2, 5, 30_000_000),
	FIRST(1, 6, 2_000_000_000),
	NO_RANK(0, 0, 0);

	private final int rank;
	private final int matchCount;
	private final long prize;

	private static final DecimalFormat PRIZE_FORMATTER = new DecimalFormat(PRIZE_PATTERN.getValue());

	Grade(int rank, int matchCount, long prize) {
		this.rank = rank;
		this.matchCount = matchCount;
		this.prize = prize;
	}

	public int getRank() {
		return rank;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public String getPrize() {
		return PRIZE_FORMATTER.format(prize);
	}

	public static Grade getGradeByRank(int rank) {
		for (Grade grade : values()) {
			if (grade.getRank() == rank) {
				return grade;
			}
		}
		return NO_RANK;
	}

	public static Grade of(int matchCount, boolean hasBonus) {
		return Arrays.stream(values())
			.filter(grade -> grade.matchCount == matchCount)
			.filter(grade -> !(grade == THIRD && hasBonus))
			.filter(grade -> !(grade == SECOND && !hasBonus))
			.findFirst()
			.orElse(NO_RANK);
	}
}
