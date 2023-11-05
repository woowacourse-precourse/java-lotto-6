package lotto.View;

import java.util.List;

public class OutputView {
	private static final String PRINT_LOTTO_QUANTITY = "%d개를 구매했습니다.\n";
	private static final String PRINT_RESULT_HEAD = "\n당첨 통계\n---";
	private static final String PRINT_PROFIT_RATE = "총 수익률은 %s%%입니다.";
	
    public static void printPurchaseLottoAmount(int input) {
    	System.out.println();
        System.out.printf(PRINT_LOTTO_QUANTITY, input);
    }

    public static void printLottoNums(List<String> lottoNums) {
        System.out.println("[" + String.join(", ", lottoNums) + "]");
    }

    public static void printResultHead() {
        System.out.println(PRINT_RESULT_HEAD);
    }
    
    public static void printResult(String printString, int count) {
        System.out.println(printString + count + "개");
    }

    public static void printProfitRate(String profitRate) {
        System.out.printf(PRINT_PROFIT_RATE, profitRate);
    }

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}
}
