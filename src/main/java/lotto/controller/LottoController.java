package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.dto.requset.Price;
import lotto.service.LottoService;
import lotto.view.Exception;
import lotto.view.ExceptionText;
import lotto.view.LottoView;
import lotto.view.Output;

public class LottoController implements Input {

	private Output lottoView;
	private Exception exceptionView;

	private LottoService lottoService;

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

	}

	@Override
	public void bonusNumber() {

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
