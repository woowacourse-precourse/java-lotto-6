package lotto.view;

import lotto.service.Service;

public enum ErrorView {
	
	CONTAIN_ALREADY("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
	INVALID_FORMAT("쉼표(,)로 구분하여 숫자만 입력해주세요."),
	NOT_LOTTO("당첨 번호는 서로 중복되지 않는 "+Service.LOTTO_SIZE+"개의 숫자입니다."),
	OUT_OF_RANGE(Service.LOTTO_RANGE_MIN+"~"+Service.LOTTO_RANGE_MAX+" 사이값만 입력 가능합니다."),
	NOT_NUMBER("숫자만 입력해주세요."),
	INDIVISIBLE("금액은 "+Service.LOTTO_PRICE+"원 단위로 입력해주세요."),
	TOO_MUCH("구입 가능한 최대 금액은 "+Service.LIMITED_AMOUNT+"원 입니다.");
	
	private final String errorMessage;
	private static final String ERROR_INTRO = "[ERROR] ";

	ErrorView(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String message() {
		return ERROR_INTRO + errorMessage;
	}

}
