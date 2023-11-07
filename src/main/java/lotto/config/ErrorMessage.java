package lotto.config;

import static lotto.config.LottoConfig.LOTTO_PRICE;
import static lotto.config.LottoConfig.LOTTO_SIZE;
import static lotto.config.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.config.LottoConfig.MIN_LOTTO_NUMBER;

public enum ErrorMessage {
	INVALID_PURCHASE_AMOUNT(String.format("[ERROR] 구매 금액은 %d원 단위의 금액이어야 합니다.", LOTTO_PRICE.getValue())),
	BLANK_PURCHASE_AMOUNT("[ERROR] 구매 금액을 입력해 주세요."),
	NON_NUMERIC_PURCHASE_AMOUNT("[ERROR] 구매 금액은 숫자만 입력 가능합니다."),
	INVALID_LOTTO_SIZE(String.format("[ERROR] 로또 번호는 %d개의 숫자로 이루어져 있습니다.", LOTTO_SIZE.getValue())),
	INVALID_LOTTO_NUMBER(String.format("[ERROR] 로또 번호는 %d~%d 사이의 숫자여야 합니다.", MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue())),
	DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
	BLANK_WINNING_NUMBERS("[ERROR] 당첨 번호를 입력해 주세요."),
	INVALID_WINNING_NUMBERS(String.format("[ERROR] 쉼표(,)를 기준으로 %d개의 정수를 입력해 주세요.", LOTTO_SIZE.getValue())),
	BLANK_BONUS_NUMBER("[ERROR] 보너스 번호를 입력해 주세요."),
	OVERLAPPED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 다른 숫자를 입력해야 합니다.");


	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}