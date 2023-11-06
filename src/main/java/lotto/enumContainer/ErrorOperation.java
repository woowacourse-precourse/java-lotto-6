package lotto.enumContainer;

public enum ErrorOperation {

	DIGIT_ERROR("[ERROR] 1이상의 숫자만 입력할 수 있습니다."),
	RANGE_ERROR("[ERROR] 범위를 초과한 금액입니다."),
	MINIMUM_ERROR("[ERROR] 1000원 이상의 금액만 입력할 수 있습니다."),
	UNIT_ERROR("[ERROR] 1000원 단위부터 입력할 수 있습니다."),
	EMPTY_ERROR("[ERROR] 빈 문자열은 유효하지 않습니다."), 
	UNDER_ERROR("[ERROR] 1보다 작은 숫자는 입력할 수 없습니다."),
	OVER_ERROR("[ERROR] 45보다 큰 숫자는 입력할 수 없습니다."),
	COLLECTION_SIZE_ERROR("[ERROR] 쉼표로 구분된 6개의 숫자를 입력해야 합니다."),
	DUPLICATE_ERROR("[ERROR] 중복된 숫자는 입력할 수 없습니다.");

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
