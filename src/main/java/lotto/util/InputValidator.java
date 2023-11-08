package lotto.util;

import static lotto.util.Constants.*;
import static lotto.util.PrintPhrase.*;
import java.util.Set;
import java.util.HashSet;

import java.util.List;

import jdk.jshell.spi.ExecutionControlProvider;

public class InputValidator {
	public static void validBudget(String budgetStr) {
		int budget = 0;
		try{
			budget = Integer.parseInt(budgetStr);
		}
		catch (IllegalArgumentException e){
			throw (new IllegalArgumentException(Exceptions.ErrorMessage.BUDGET_IS_NOT_NUM));
		}
		if (budget % LOTTO_PRICE != 0) {
			throw (new IllegalArgumentException(Exceptions.ErrorMessage.BUDGET_UNIT_WRONG));
		}
	}

	public static void validWinningNums(String inputString) {
		if (inputString.startsWith(",")) {
			throw (new IllegalArgumentException(Exceptions.ErrorMessage.WINNINGNUM_NOT_SIX));
		}
		if (inputString.endsWith(",")) {
			throw (new IllegalArgumentException(Exceptions.ErrorMessage.WINNINGNUM_NOT_SIX));
		}
		String [] winningNums = inputString.split(",");
		if (winningNums.length != COUNT_OF_LOTTO) {
			throw (new IllegalArgumentException(Exceptions.ErrorMessage.WINNINGNUM_NOT_SIX));
		}
		try {
			for (String s : winningNums) {
				int parsingNum = Integer.parseInt(s);
				if (parsingNum > LOTTO_RANDOM_NUMBER_MAX || parsingNum < LOTTO_RANDOM_NUMBER_MIN)
					throw (new IllegalArgumentException(Exceptions.ErrorMessage.WINNINGNUM_RANGE_WRONG));
			}
		} catch (IllegalArgumentException e) {
			System.out.println(Exceptions.ErrorMessage.NOT_NUM);
		}
	}

	public static void validDistinctNums(List<Integer> winningNums) {
		Set<Integer> uniqueNumbers = new HashSet<>(winningNums);
		if (uniqueNumbers.size() != COUNT_OF_LOTTO){
			throw (new IllegalArgumentException(Exceptions.ErrorMessage.WINNINGNUM_NOT_DISTINCT));
		}
	}

	public static void validBonusNum(List<Integer> winningNums, int bonusNumber) {
		if (winningNums.contains(bonusNumber)){
			throw (new IllegalArgumentException(Exceptions.ErrorMessage.BONUSNUM_DUPLICATION));
		}
	}
}
