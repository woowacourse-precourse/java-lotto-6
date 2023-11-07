package lotto.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Rank;
import lotto.utils.Utils;
import lotto.validation.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Service {
	
	private static final int LOTTO_RANGE_MIN = 1;
	private static final int LOTTO_RANGE_MAX = 45;
	private static final int LOTTO_SIZE = 6;
	private static final int LOTTO_PRICE = 1_000;
	private static final int LIMITED_AMOUNT = 100_000;
	
	Buyer buyer;
	LottoGame lottoGame;
	
	public void readyLottoGame() {
		lottoGame = new LottoGame(getInputWinningNumbers());
		int bonusNumber = getBonusNumber();
		Validation.validateNumberNotInList(lottoGame.getWinningNumbers(), bonusNumber);
		lottoGame.setBonusNumber(bonusNumber);
	}
	
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
		List<Integer> numbers = Utils.generateUniqueNumberListInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, LOTTO_SIZE);
		Utils.sortListAscendingOrder(numbers);
		return new Lotto(numbers);
	}
	
	public int getInputAmount() {
		InputView.inputAmount();
		String input = Console.readLine().trim();
		Validation.validateNaturalNumber(input);
		int paid = Integer.valueOf(input);
		Validation.validateDividablePaid(paid, LOTTO_PRICE);
		Validation.validateBuyableAmount(paid, LIMITED_AMOUNT);
		return paid;
	}
	
	public List<Integer> getInputWinningNumbers() {
		InputView.inputWinningNumbers();
		String input = Console.readLine().trim();
		Validation.validateInputFormat(input);
		List<Integer> numbers = Utils.stringToIntegerList(input);
		Validation.validateListNumbersInRange(numbers, LOTTO_RANGE_MIN, LOTTO_RANGE_MAX);
		return numbers;
	}
	
	public int getBonusNumber() {
		InputView.inputBonusNumber();
		String input = Console.readLine().trim();
		Validation.validateNaturalNumber(input);
		int bonusNumber = Integer.valueOf(input);
		Validation.validateNumberInRange(bonusNumber, LOTTO_RANGE_MIN, LOTTO_RANGE_MAX);
		return bonusNumber;
	}
	
	public int countCorrectLottoNumber(Lotto lotto) {
		return Utils.countSameNumbers(lotto.getNumbers(), lottoGame.getWinningNumbers());
	}
	
	public boolean isBonusNumberCorrect(Lotto lotto) {
		return lotto.getNumbers().contains(lottoGame.getBonusNumber());
	}

}
