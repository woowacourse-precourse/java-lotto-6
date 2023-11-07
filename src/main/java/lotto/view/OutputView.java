package lotto.view;

import java.util.List;

public class OutputView {
	
	public static void printCountOfLotto(int count) {
		System.out.printf("\n%d개를 구매했습니다.\n", count);
	}

	public static void printNumbersOfLotto(List<Integer> numbers) {
		System.out.println(numbers);
	}
	
	public static void printResultIntro() {
		System.out.println("\n당첨 통계\n---");
	}

	public static void printOneRankResult(int standardCount, String prizeText, int cerrectCount) {
		System.out.printf("%d개 일치 (%s원) - %d개\n", standardCount, prizeText, cerrectCount);
	}
	
	public static void printSecondRankResult(int standardCount, String prizeText, int cerrectCount) {
		System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", standardCount, prizeText, cerrectCount);
	}
	
	public static void printYieldRate(double yieldRate) {
		System.out.printf("총 수익률은 %.1f%%입니다.", yieldRate);
	}
	
}
