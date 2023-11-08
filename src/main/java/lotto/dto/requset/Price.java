package lotto.dto.requset;

import lotto.view.ExceptionText;

public class Price {

	String price;

	public Price(String price) {
		validatePriceInput(price);
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	private void validatePriceInput(String input) {
		checkInputIsEmpty(input);
		checkInputIsNumber(input);
	}

	private static void checkInputIsEmpty(String input) {
		if (input == null || input.isEmpty()) {
			throw new NullPointerException(ExceptionText.EMPTY.getText());
		}
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
}
