package lotto;

import java.util.List;
import java.text.DecimalFormat;

public class Profit {

	private static final String PROFIT_ZERO = "0.0";

	public static void calculate(List<WinningRank> rankings, int money) {

		int totalWinnings = calculateWinningMoney(rankings);

		double profit = calculateProfitPercentage(totalWinnings, money);

		printResult(profit);
	}

	private static int calculateWinningMoney(List<WinningRank> rankings) {

		int WinningMoney = 0;

		for (WinningRank rank : rankings) {
			WinningMoney += rank.getWinningmoney();
		}

		return WinningMoney;
	}

	public static double calculateProfitPercentage(int WinningMoney, int userMoney) {

		double profit = (double) WinningMoney / userMoney * 100;

		if (profit != 0) {
			return Math.round(profit * 100.0) / 100.0;
		}
		return 0;
	}

	private static void printResult(double profit) {

		String profitPercent = profitFormat(profit);

		System.out.println("총 수익률은 " + profitPercent + "%입니다.");
	}

	private static String profitFormat(double profit) { // 000,000.00%으로 출력하기 위한 메서드

		if (profit != 0) {
			DecimalFormat df = new DecimalFormat("###,###.0");
			String formattedProfit = df.format(profit);

			return formattedProfit;
		}
		return PROFIT_ZERO;
	}

}