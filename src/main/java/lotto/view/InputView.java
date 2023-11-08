package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.PrintPhrase;
import lotto.util.InputValidator;


import java.util.List;
import java.util.ArrayList;

public class InputView {
	public static int getBudget() {
		System.out.println();
		System.out.println(PrintPhrase.InputMessage.MSG_PURCHASE_PRICE);
		String budgetString = Console.readLine();
		int budget = 0;
		try {
			InputValidator.validBudget(budgetString);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getBudget();
		}
		budget = Integer.parseInt(budgetString);
		return budget;
	}
	public static int getBonusNum(List<Integer> winningNums) {
		System.out.println();
		System.out.println(PrintPhrase.InputMessage.MSG_BONUS_NUMS);
		int bonusNumber = 0;
		try{
			bonusNumber = Integer.parseInt(Console.readLine());
			InputValidator.validBonusNum(winningNums, bonusNumber);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getBonusNum(winningNums);
		}
		return bonusNumber;
	}
	public static List<Integer> getWinningNums() {
		System.out.println();
		System.out.println(PrintPhrase.InputMessage.MSG_WINNING_NUMS);
		List<Integer> winningNums = new ArrayList<>();
		try{
			String inputString = Console.readLine();
			InputValidator.validWinningNums(inputString);
			String numStrings[] = inputString.split(",");
			for (String s : numStrings) {
				winningNums.add(Integer.parseInt(s));
			}
			InputValidator.validDistinctNums(winningNums);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getWinningNums();
		}
		return winningNums;
	}
}
