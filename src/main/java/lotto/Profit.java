package lotto;

import java.util.List;

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

		return (double) WinningMoney / userMoney * 100;
	}

	private static void printResult(double profit) {
		System.out.println("총 수익률은 " + profit + "%입니다.");
	}
}