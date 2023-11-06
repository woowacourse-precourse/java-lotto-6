package lotto.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.utils.Utils;
import lotto.validation.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Service {
	
	private static final int LOTTO_START_INCLUSIVE = 1;
	private static final int LOTTO_END_INCLUSIVE = 45;
	private static final int LOTTO_SIZE = 6;
	private static final int LOTTO_PRICE = 1_000;
	private static final int BUYABLE_MAX_AMOUNT = 100_000;
	
	Buyer buyer;
	
	public void initBuyer() {
		buyer = new Buyer(getInputAmount());
	}
	
	public void buyOneLotto() {
		Lotto lotto = generateLotto();
		buyer.buyLotto(lotto);
	}
	
	public void buyLotteries() {
		int count = buyer.getPurchaseAmount() / LOTTO_PRICE;
		for (int i = 0; i < count; i++) {
			buyOneLotto();
		}
	}
	
	public void showBuyingResult() {
		OutputView.printCountOfLotto(buyer.getPurchaseAmount() / LOTTO_PRICE);
		for(Lotto lotto : buyer.getPurchasedLotteries()) {
			OutputView.printNumbersOfLotto(lotto.getNumbers());
		}
	}
	
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
	
	public Lotto getWinningNumbers() {
		InputView.inputWinningNumbers();
		String input = Console.readLine().trim();
		Validation.validateInputFormat(input);
		List<Integer> numbers = Utils.stringToIntegerList(input);
		Validation.validateListNumbersInRange(numbers, LOTTO_START_INCLUSIVE, LOTTO_END_INCLUSIVE);
		return new Lotto(numbers);
	}
	
	public int getBonusNumber(List<Integer> winningNumbers) {
		InputView.inputBonusNumber();
		String input = Console.readLine().trim();
		Validation.validateNaturalNumber(input);
		int bonusNumber = Integer.valueOf(input);
		Validation.validateNumberInRange(bonusNumber, LOTTO_START_INCLUSIVE, LOTTO_END_INCLUSIVE);
		Validation.validateNumberNotInList(winningNumbers, bonusNumber);
		return bonusNumber;
	}
	
	

}
