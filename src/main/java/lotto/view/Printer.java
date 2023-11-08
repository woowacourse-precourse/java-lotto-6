package lotto.view;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Rank;

public class Printer {

	public void printDirection(String direction) {
		System.out.print(direction);
	}
	
	public void printLottoTickets(int ticketsQty, List<List<Integer>> tickets) {
		System.out.println("\n" + ticketsQty + "개를 구매했습니다.");
		for (List<Integer> numbers : tickets) {
			System.out.println(numbers);
		}
	}
	
	public void printWinnersDetail(List<Rank> rank) {
		
		int[] winnerCount = countWinnerTickets(rank);
		
		String data = "";
		data += "\n당첨 통계\n";
		data += "---\n";
		data += "3개 일치 (5,000원) - " + winnerCount[4] + "개\n";
		data += "4개 일치 (50,000원) - " + winnerCount[3] + "개\n";
		data += "5개 일치 (1,500,000원) - " + winnerCount[2] + "개\n";
		data += "5개 일치, 보너스 볼 일치 (30,000,000원) - " + winnerCount[1] + "개\n";
		data += "6개 일치 (2,000,000,000원) - " + winnerCount[0] + "개";
		System.out.println(data);
	}
	
	public int[] countWinnerTickets(List<Rank> rank) {
		int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0;
		for (Rank rankName : rank) {
			if (rankName.getReward() == 2000000000) c1++;
			if (rankName.getReward() == 30000000) c2++;
			if (rankName.getReward() == 1500000) c3++;
			if (rankName.getReward() == 50000) c4++;
			if (rankName.getReward() == 5000) c5++;
		}
		int[] count = {c1, c2, c3, c4, c5};
		return count;
	}
	
}
