package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.dto.requset.Price;

public class LottoController implements Input {

	@Override
	public void purchasePrice() {
		System.out.println("테스트 가격 입력");
		try {
			Price price = new Price(readLine());
			validatePriceInput(price.getPrice());
			System.out.println("성공" + price.getPrice());
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
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
			throw new IllegalArgumentException("유효한 숫자 형식이 아닙니다.");
		}
	}

	private static void checkInputIsMultiple(int priceValue) {
		if (priceValue % 1000 != 0) {
			throw new IllegalArgumentException("가격은 1000으로 나누어 떨어져야 합니다.");
		}
	}

	private static void checkInputIsEmpty(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("구입 가격을 입력해주세요.");
		}
	}
}
