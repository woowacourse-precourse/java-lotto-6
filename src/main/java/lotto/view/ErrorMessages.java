package lotto.view;

import lotto.global.util.Constants;

public enum ErrorMessages {
	INVALID_NUMBER_COUNT(String.format("로또 번호는 %d개의 숫자여야 합니다.", Constants.LOTTO_NUMBER_COUNT.value)),
	INVALID_NUMBER_FORMAT("숫자를 입력해야 합니다."),
	INVALID_NUMBER_RANGE(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", Constants.MIN_LOTTO_NUMBER.value, Constants.MAX_LOTTO_NUMBER.value)),
	NUMBER_DUPLICATION("로또 번호는 중복될 수 없습니다."),
	INDIVISIBLE_PRICE(String.format("로또 구입 금액은 %d원 단위여야 합니다.", Constants.PRICE_UNIT.value));

	public String message;

	ErrorMessages(String message) {
		this.message = message;
	}
}