package lotto.view;

import lotto.message.PrintMessage;

public class OutputView {
	
	public void printPurchaseAmount() {
		System.out.println(PrintMessage.PURCHASE_LOTTO.getMessage());
	}
	
	public void printLottoAmount(int lottoAmount) {
		System.out.println(lottoAmount + PrintMessage.PRINT_LOTTO.getMessage());
	}
	
	public void printWinningNumbers() {
		System.out.println(PrintMessage.INPUT_LOTTO_WINNING_NUMBER.getMessage());
	}
	
	public void printBonusNumber() {
		System.out.println(PrintMessage.INPUT_LOTTO_BONUS_NUMBER.getMessage());
	}
	
	public void printResult() {
		System.out.println(PrintMessage.RESULT_LOTTO_HEADER.getMessage());
	}
	
	public void printCompareResult() {
		System.out.println(PrintMessage.COMPARE_RESULT3.getMessage());
		System.out.println(PrintMessage.COMPARE_RESULT4.getMessage());
		System.out.println(PrintMessage.COMPARE_RESULT5.getMessage());
		System.out.println(PrintMessage.COMPARE_RESULT5_2.getMessage());
		System.out.println(PrintMessage.COMPARE_RESULT6.getMessage());
	}
	
	public void printRate() {
		System.out.println("총 수익률은"+"입니다.");
	}
	
//	3개 일치 (5,000원) - 1개
//	4개 일치 (50,000원) - 0개
//	5개 일치 (1,500,000원) - 0개
//	5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//	6개 일치 (2,000,000,000원) - 0개
//	총 수익률은 62.5%입니다.
}
