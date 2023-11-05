package lotto.enums;

public enum LottoError {
	INVALID_SIZE_INPUT("[ERROR] 로또 번호는 총 6개의 숫자로 이루어져야 합니다."),
	INVALID_RANGE_INPUT("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
	INVALID_REDUNDANT_INPUT("[ERROR] 로또 번호는 중복된 숫자가 존재해서는 안됩니다."),
	INVALID_BONUS_NUMBER("[ERROR] 보너스 넘버는 기존 로또 번호와 달라야 합니다."),
	INVALID_INPUT_NUMBER("[ERROR] 로또 번호로 숫자를 입력해야 합니다.");

	private String errorDescription;

	LottoError(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getErrorDescription() {
		return this.errorDescription;
	}
}
