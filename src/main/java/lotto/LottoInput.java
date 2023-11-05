package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.HashSet;

class LottoInput {
	protected static int getPurchaseAmount() {
		LottoPrint.printPurchase();
		
		int amount = Integer.valueOf(Console.readLine());
		
		return amount;
	}
	
	protected static List<Integer> getWinningNumber(){
		LottoPrint.printWinningNumbers();
		
		String inputNumbers = Console.readLine();
		List<Integer> winningNumbers = Arrays.asList(inputNumbers.split(",")).stream()
				.map(Integer::valueOf)
				.collect(Collectors.toList());
		
		return winningNumbers;
	}
	
	protected static int getBonusNumber() {
		LottoPrint.printBonusNumber();
		
		int bonusNumber = Integer.valueOf(Console.readLine());
		
		return bonusNumber;
	}
}
