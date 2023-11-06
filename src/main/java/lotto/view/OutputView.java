package lotto.view;

import java.util.List;

public class OutputView {
	
	public static void printCountOfLotto(int count) {
		System.out.printf("%d개를 구매했습니다.\n", count);
	}

	public static void printNumbersOfLotto(List<Integer> numbers) {
		System.out.println(numbers);
	}
	
}
