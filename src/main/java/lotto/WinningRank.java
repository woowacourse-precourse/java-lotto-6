package lotto;

import java.util.List;

public enum WinningRank {

	FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
	SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
	FOURTH(4, 50000, "4개 일치 (50,000원) - "),
	FIFTH(3, 5000, "3개 일치 (5,000원) - "),
	NONE(0, 0, "");

	private int matchingNumbers;
	private int winningmoney;
	private String message;

	WinningRank(int matchingNumbers, int winningmoney, String message) {
		this.matchingNumbers = matchingNumbers;
		this.winningmoney = winningmoney;
		this.message = message;
	}

	public int getWinningmoney() {
		return winningmoney;
	}

	public int getMatchingNumbers() {
		return matchingNumbers;
	}

	public String getMessage() {
		return message;
	}

	public static WinningRank findByMatchingNumbers(int matchingNumbers) {
		for (WinningRank rank : values()) {
			if (matchingNumbers >= rank.matchingNumbers) {
				return rank;
			}
		}
		return NONE;
	}

	public static void printResult(List<WinningRank> rankingList) {

		int[] countByRank = new int[WinningRank.values().length];
		WinningRank[] ranks = WinningRank.values();

		for (WinningRank rank : rankingList) {
			countByRank[rank.ordinal()]++;
		}

		System.out.println("");
		System.out.println("당첨 통계");
		System.out.println("---");

		for (int i = ranks.length - 1; i >= 0; i--) { // 역순 출력
			WinningRank rank = ranks[i];
			int count = countByRank[rank.ordinal()];

			if (rank != WinningRank.NONE) {
				String message = rank.getMessage();
				System.out.println(message + count + "개");
			}
		}
	}

}
