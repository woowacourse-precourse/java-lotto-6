package lotto.validator;

import java.util.StringTokenizer;

public class LottoValidatorImpl implements LottoValidator{

	@Override
	public int validate(String price) {
		validateIsDigit(price);
		return validateRange(price);
	}

	private void validateIsDigit(String price) {
		for (int i = 0; i < price.length(); i++) {
			char digit = price.charAt(i);
			if (!Character.isDigit(digit)) {
				throw new IllegalArgumentException("구입 금액에는 숫자만 입력할 수 있습니다.");
			}
		}
	}
	
	private int validateRange(String price) {
		try {
			return Integer.parseInt(price);
		} catch (NumberFormatException e) {
			e.getStackTrace();
			throw new IllegalArgumentException("int 범위를 초과한 금액입니다.");
		}
	}
}
