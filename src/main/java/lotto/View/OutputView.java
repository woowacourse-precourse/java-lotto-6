package lotto.View;

import java.util.List;

public class OutputView {
    public static void printPurchaseLottoAmount(int input) {
        System.out.println();
        System.out.println(input + "개를 구매했습니다.");
    }

    public static void printLottoNums(List<String> lottoNums) {
        System.out.println("[" + String.join(", ", lottoNums) + "]");
    }

    public static void printResultHead() {
        System.out.println("\n당첨 통계\n---");
    }
    
    public static void printResult(String printString, int count) {
        System.out.println(printString + count + "개");
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}
}
