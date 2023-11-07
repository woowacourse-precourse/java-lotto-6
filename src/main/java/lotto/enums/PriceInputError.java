package lotto.enums;

public enum PriceInputError {

	INVALID_TYPE_INPUT("[ERROR] 숫자를 입력해 주세요"),
	INVALID_UNIT_INPUT("[ERROR] 1000원 단위로 금액을 입력해 주세요");

	private String errorDescription;

	PriceInputError(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getErrorDescription() {
		return this.errorDescription;
	}
}
