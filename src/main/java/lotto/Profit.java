package lotto;

import java.util.List;
import java.text.DecimalFormat;

public class Profit {

	public static void calculate(List<WinningRank> rankingList, String money) {

		int userMoney = Integer.parseInt(money);

		int totalWinnings = calculateWinningMoney(rankingList);

		double profit = calculateProfitPercentage(totalWinnings, userMoney);

		printResult(profit);
	}

	private static int calculateWinningMoney(List<WinningRank> rankingList) {

		int WinningMoney = 0;

		for (WinningRank rank : rankingList) {
			WinningMoney += rank.getWinningmoney();
		}

		return WinningMoney;
	}

	private static double calculateProfitPercentage(int WinningMoney, int userMoney) {

		double profit = (double) WinningMoney / userMoney * 100;

		return Math.round(profit * 100.0) / 100.0;
	}

	private static void printResult(double profit) {

		if (profit != 0) {
			DecimalFormat df = new DecimalFormat("###,###,###.0");
			String formattedProfit = df.format(profit);
			
			System.out.println("총 수익률은 " + formattedProfit + "%입니다.");
		}
		
		System.out.println("총 수익률은 0.0%입니다.");
	}
}