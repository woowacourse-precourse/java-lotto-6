package lotto.view;

import java.util.Map;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;

public class OutputView {
	
	private final String COUNT_BUY_MESSAGE = "\n%d개를 구매했습니다.\n";
	private final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
	private final String TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 %,.1f%%입니다.\n";
	
	public void lottos(Lottos lottos) {
		System.out.printf(COUNT_BUY_MESSAGE,lottos.getSize());
		
		for(Lotto lotto : lottos.getLottos()) {
			System.out.println(lotto.getNumbers());
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
			if(rank.equals(Rank.NOTHING))
				break;
			System.out.println(rank.getMessage(winnings.get(rank)));
		}
	}
	
	private void totalProfitRate(double profitRate) {
		System.out.printf(TOTAL_PROFIT_RATE_MESSAGE, profitRate);
	}
}
