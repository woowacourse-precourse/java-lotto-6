package lotto.io;

import java.util.List;

public class Output {

	private static final String FIFTH_PRIZE_MESSAGE = "3개 일치 (5,000원) - %d개\n";
	private static final String FOURTH_PRIZE_MESSAGE = "4개 일치 (50,000원) - %d개\n";
	private static final String THIRD_PRIZE_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
	private static final String SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
	private static final String FIRST_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
	private static final String TOTAL_RETURN_RATE_MESSAGE = "총 수익률은 %.2f입니다.\n";

	public static void printFunction(List<Integer> result, final int totalPrize, final int purchaseAmount) {
		System.out.printf(FIFTH_PRIZE_MESSAGE, result.get(5));
		System.out.printf(FOURTH_PRIZE_MESSAGE, result.get(4));
		System.out.printf(THIRD_PRIZE_MESSAGE, result.get(3));
		System.out.printf(SECOND_PRIZE_MESSAGE, result.get(2));
		System.out.printf(FIRST_PRIZE_MESSAGE, result.get(1));
		System.out.printf(TOTAL_RETURN_RATE_MESSAGE, (double)(totalPrize / purchaseAmount) * 100);
	}
}
