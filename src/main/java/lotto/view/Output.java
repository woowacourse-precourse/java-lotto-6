package lotto.view;

import java.util.ArrayList;
import java.util.Map;

import lotto.model.Rank;

public class Output {
	
	private final String COUNT_BUY_MESSAGE = "%d개를 구매했습니다.\n";
	private final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";
	private final String TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
	
	
	public void lottos(ArrayList<ArrayList<Integer>>lotto) {
		System.out.printf(COUNT_BUY_MESSAGE,lotto.size());
		for(int i = 0;i<lotto.size();i++) {
			System.out.println(lotto.get(i).toString());
		}
		System.out.println();
	}
	
	public void statistics(Map<Rank,Integer> winnings, double profitRate) {
		System.out.println(WINNING_STATISTICS_MESSAGE);
		prizeWinner(winnings);
		totalProfitRate(profitRate);
	}
	private void prizeWinner(Map<Rank,Integer> winnings) {
		for (Rank rank : winnings.keySet()) {
			System.out.println(rank.getMessage(winnings.get(rank)));
		}
	}
	private void totalProfitRate(double profitRate) {
		System.out.printf(TOTAL_PROFIT_RATE_MESSAGE, profitRate);
	}
}
