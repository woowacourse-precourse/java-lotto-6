package lotto.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.utils.Utils;
import lotto.validation.Validation;
import lotto.view.InputView;

public class Service {
	
	private static final int LOTTO_START_INCLUSIVE = 1;
	private static final int LOTTO_END_INCLUSIVE = 45;
	private static final int LOTTO_SIZE = 6;
	private static final int LOTTO_PRICE = 1_000;
	private static final int BUYABLE_MAX_AMOUNT = 100_000;
	
	public Lotto generateLotto() {
		List<Integer> numbers = Utils.generateUniqueNumberListInRange(LOTTO_START_INCLUSIVE, LOTTO_END_INCLUSIVE, LOTTO_SIZE);
		Utils.sortListAscendingOrder(numbers);
		return new Lotto(numbers);
	}
	
	public int getInputAmount() {
		InputView.inputAmount();
		String input = Console.readLine().trim();
		Validation.validateNaturalNumber(input);
		int paid = Integer.valueOf(input);
		Validation.validateDividablePaid(paid, LOTTO_PRICE);
		Validation.validateBuyableAmount(paid, BUYABLE_MAX_AMOUNT);
		return paid;
	}

}
