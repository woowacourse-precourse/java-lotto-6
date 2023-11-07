package lotto.view;

import java.util.List;

import lotto.message.PrintMessage;
import lotto.model.Lotto;

public class OutputView {
	
	public void printMoney() {
		System.out.println(PrintMessage.PURCHASE_LOTTO.getMessage());
	}
	
	public void printLottoAmount(int amount) {
		System.out.println("\n"+ amount + PrintMessage.PRINT_LOTTO.getMessage());
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
	
	public void printCompareResult(int matchCount) {
		System.out.println(PrintMessage.FIRST.getMessage()+matchCount);
		System.out.println(PrintMessage.SECOND.getMessage()+matchCount);
		System.out.println(PrintMessage.THIRD.getMessage()+matchCount);
		System.out.println(PrintMessage.FOURTH.getMessage()+matchCount);
		System.out.println(PrintMessage.FIFTH.getMessage()+matchCount);
	}
	
	public void printRate() {
		System.out.println("총 수익률은"+"입니다.");
	}
	
	public void printLotto(List<Integer> numbers) { //
		System.out.println(numbers);
	}
	
//	3개 일치 (5,000원) - 1개
//	4개 일치 (50,000원) - 0개
//	5개 일치 (1,500,000원) - 0개
//	5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//	6개 일치 (2,000,000,000원) - 0개
//	총 수익률은 62.5%입니다.
}
