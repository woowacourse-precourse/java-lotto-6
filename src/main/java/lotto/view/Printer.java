package lotto.view;

import java.util.List;

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
	
}
