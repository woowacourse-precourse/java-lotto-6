package lotto;

import java.util.Arrays;

public enum Ranking {

	MISS(0, 0, ""), FIFTH(3, 5_000, "3개 일치 (5,000원) - "), FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
	THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), SECOND(7, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

	private final int index;
	private final int winningAmount;
	private final String msg;

	Ranking(int index, int winningAmount, String msg) {
		this.index = index;
		this.winningAmount = winningAmount;
		this.msg = msg;
	}

	public static Ranking getIndex(int number) { // index를 기준으로 식별자 필터링
		return Arrays.stream(Ranking.values()).filter(x -> x.index == number).findAny().orElse(MISS);
	}

	public static int getWinningAmount(int number) {
		return getIndex(number).getAmount();
	}

	public static String getPrintMsg(int number) {
		return getIndex(number).getMsg();
	}

	public int getAmount() {
		return this.winningAmount;
	}

	public String getMsg() {
		return this.msg;
	}
}