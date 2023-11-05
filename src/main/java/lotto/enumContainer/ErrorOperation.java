package lotto.enumContainer;

public enum ErrorOperation {

	DIGIT_ERROR("[ERROR] 숫자만 입력할 수 있습니다."),
	RANGE_ERROR("[ERROR] 범위를 초과한 금액입니다."),
	MINIMUM_ERROR("[ERROR] 1000원 이상의 금액만 입력할 수 있습니다."),
	UNIT_ERROR("[ERROR] 1000원 단위부터 입력할 수 있습니다.");

	private String message;
	private
	ErrorOperation(String message) {
		this.message = message;
	}

	public void apply() {
		throw new IllegalArgumentException(this.message);
		//재입력 메소드 구현
	}
}
