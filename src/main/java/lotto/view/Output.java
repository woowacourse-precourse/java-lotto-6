package lotto.view;

import java.util.ArrayList;

public class Output {
	
	private final String COUNT_BUY_MESSAGE = "%d개를 구매했습니다.\n";
	private final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";
	private final String FIRST_PRIZE_WINNER_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
	private final String SECOND_PRIZE_WINNER_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
	private final String THIRD_PRIZE_WINNER_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
	private final String FOURTH_PRIZE_WINNER_MESSAGE = "4개 일치 (50,000원) - %d개\n";
	private final String FIFTH_PRIZE_WINNER_MESSAGE = "3개 일치 (5,000원) - %d개\n";
	private final String TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 %.1lf%%입니다.";
	
	
	public void lottos(ArrayList<ArrayList<Integer>>lotto) {
		System.out.printf(COUNT_BUY_MESSAGE,lotto.size());
		for(int i = 0;i<lotto.size();i++) {
			System.out.println(lotto.get(i).toString());
		}
		System.out.println();
	}
}
