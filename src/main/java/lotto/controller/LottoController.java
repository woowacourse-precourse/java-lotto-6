package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lotto.dto.requset.Price;
import lotto.dto.requset.WinningBonusNumber;
import lotto.service.LottoService;
import lotto.view.Exception;
import lotto.view.ExceptionText;
import lotto.view.Output;

public class LottoController implements Input {

	private Output lottoView;
	private Exception exceptionView;

	private LottoService lottoService;

	private final WinningBonusNumber winningBonusNumber = new WinningBonusNumber();

	public LottoController(Output lottoView, Exception exceptionView, LottoService lottoService) {
		this.lottoView = lottoView;
		this.exceptionView = exceptionView;
		this.lottoService = lottoService;
	}

	@Override
	public void purchasePrice() {
		lottoView.Intro();
		try {
			Price price = new Price(readLine());
			validatePriceInput(price.getPrice());
			System.out.println("성공" + price.getPrice());
			lottoView.PurchaseCompleted(lottoService.createLotto(price.getPrice()));
		} catch (IllegalArgumentException e) {
			exceptionView.PriceException(e);
			purchasePrice();
		}
	}

	@Override
	public void winningNumber() {
		lottoView.WinningNumber();
		try {
			winningBonusNumber.setWinningNumber(readLine());
			validateWinningInput(winningBonusNumber.getWinningNumber());
			System.out.println(winningBonusNumber.getWinningNumber()+"성공");
		} catch (IllegalArgumentException e) {
			exceptionView.PriceException(e);
			winningNumber();
		}
	}

	@Override
	public void bonusNumber() {
		lottoView.BonusNumber();
		try {
			winningBonusNumber.setBonusNumber(readLine());
			checkInputIsEmpty(winningBonusNumber.getBonusNumber());
			ScopeCheck(Integer.parseInt(winningBonusNumber.getBonusNumber()));
			checkForOverlap(winningBonusNumber.getWinningNumber(),
				winningBonusNumber.getBonusNumber());
			System.out.println(winningBonusNumber.getBonusNumber()+"성공");
			lottoService.winningCalculation(winningBonusNumber);
		} catch (IllegalArgumentException e) {
			exceptionView.PriceException(e);
			bonusNumber();
		}
	}



	public void checkForOverlap(String winningNumber, String bonusNumber) {
		String[] winningNumbers = winningNumber.split(",");
		String[] bonusNumbers = bonusNumber.split(",");

		Set<String> winningSet = new HashSet<>(Arrays.asList(winningNumbers));
		Set<String> bonusSet = new HashSet(Arrays.asList(bonusNumbers));

		winningSet.retainAll(bonusSet);

		if (!winningSet.isEmpty()) {
			throw new IllegalArgumentException(ExceptionText.DUPLICATE_WIN_BONUS.getText());
		}
	}

	private void validateWinningInput(String winningNumber) {
		checkInputIsEmpty(winningNumber);
		String[] parts = winningNumber.split(",");
		numbersCountCheck(parts);
		Set<Integer> uniqueNumbers = new HashSet<>();
		for (String part : parts) {
			numbersCheck(uniqueNumbers, part);
		}
	}

	private static void numbersCountCheck(String[] parts) {
		if (parts.length != 6) {
			throw new IllegalArgumentException(ExceptionText.DIFFERENT_NUMBER.getText());
		}
	}

	private static void numbersCheck(Set<Integer> uniqueNumbers, String part) {
		try {
			int number = Integer.parseInt(part);
			ScopeCheck(number);
			DuplicateCheck(uniqueNumbers, number);
			uniqueNumbers.add(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionText.INPUT_NUMBER_ERROR.getText());

		}
	}

	private static void DuplicateCheck(Set<Integer> uniqueNumbers, int number) {
		if (uniqueNumbers.contains(number)) {
			throw new IllegalArgumentException(ExceptionText.DUPLICATE_NUMBERS.getText());
		}
	}

	private static void ScopeCheck(int number) {
		if (number < 1 || number > 45) {
			throw new IllegalArgumentException(ExceptionText.BEYOND_SCOPE.getText());
		}
	}

	private void validatePriceInput(String input) {
		checkInputIsEmpty(input);
		checkInputIsNumber(input);
	}

	private static void checkInputIsNumber(String input) {
		try {
			int priceValue = Integer.parseInt(input);
			checkInputIsMultiple(priceValue);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionText.NUMBER.getText());
		}
	}

	private static void checkInputIsMultiple(int priceValue) {
		if (priceValue % 1000 != 0) {
			throw new IllegalArgumentException(ExceptionText.MULTIPLE.getText());
		}
	}

	private static void checkInputIsEmpty(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException(ExceptionText.EMPTY.getText());
		}
	}
}
