package lotto.validator;

public class LottoValidatorImpl implements LottoValidator{

	@Override
	public int validatePrice(String price) {
		validateIsDigit(price);
		int parsePrice = validateRange(price);
		validateRest(parsePrice);
		return parsePrice;
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
			int parsePrice = Integer.parseInt(price);
			return validateMinimum(parsePrice);
		} catch (NumberFormatException e) {
			e.getStackTrace();
			throw new IllegalArgumentException("int 범위를 초과한 금액입니다.");
		}
	}

	private int validateMinimum(int parsePrice) {
		if (parsePrice < 1000) {
			throw new IllegalArgumentException("금액의 최소 금액은 1000원입니다.");
		}
		return parsePrice;
	}

	private void validateRest(int parsePrice) {
		if (parsePrice%1000 != 0) {
			throw new IllegalArgumentException("1000원 단위로 입력해야 합니다.");
		}
	}
}
