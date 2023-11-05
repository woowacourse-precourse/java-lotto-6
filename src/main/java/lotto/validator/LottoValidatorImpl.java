package lotto.validator;

import java.util.StringTokenizer;

public class LottoValidatorImpl implements LottoValidator{

	public void validateIsDigit(String price) {
		for (int i = 0; i < price.length(); i++) {
			char digit = price.charAt(i);
			if (!Character.isDigit(digit)) {
				throw new IllegalArgumentException("구입 금액에는 숫자만 입력할 수 있습니다.");
			}
		}
	}


}
