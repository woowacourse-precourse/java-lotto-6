package lotto.view;

import lotto.domain.Lotto;
import lotto.service.Service;

public enum ErrorView {
	
	BONUS_NUMBER_ERROR("보너스 번호는 당첨 번호와 중복되지 않는"+Lotto.MIN_NUMBER+"~"+Lotto.MAX_NUMBER+" 사이의 숫자입니다."),
	NOT_LOTTO("서로 중복되지 않는 "+Lotto.MIN_NUMBER+"~"+Lotto.MAX_NUMBER+" 사이의 숫자 "+Lotto.SIZE+"개를 입력하세요."
			+ "\n각 숫자는 쉼표(,)로 구분합니다."),
	AMOUNT_ERROR("구입 가능한 금액은 "+Service.LOTTO_PRICE+"원 단위로, 최대 "+Service.LIMITED_AMOUNT+"원 입니다. 숫자만 입력해주세요.");
	
	private final String errorMessage;
	private static final String ERROR_INTRO = "[ERROR] ";

	ErrorView(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String message() {
		return ERROR_INTRO + errorMessage;
	}

}
