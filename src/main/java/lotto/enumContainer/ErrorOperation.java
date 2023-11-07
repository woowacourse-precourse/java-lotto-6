package lotto.enumContainer;

public enum ErrorOperation {

	DIGIT_ERROR("[ERROR] 숫자만 입력할 수 있습니다."),
	RANGE_ERROR("[ERROR] 범위를 초과한 금액입니다."),
	MINIMUM_ERROR("[ERROR] 1000원 이상의 금액만 입력할 수 있습니다."),
	UNIT_ERROR("[ERROR] 1000원 단위부터 입력할 수 있습니다."),
	EMPTY_ERROR("[ERROR] 입력값이 필요합니다."),
	UNDER_ERROR("[ERROR] 1보다 작은 숫자는 입력할 수 없습니다."),
	OVER_ERROR("[ERROR] 45보다 큰 숫자는 입력할 수 없습니다."),
	COLLECTION_SIZE_ERROR("[ERROR] 쉼표로 구분된 6개의 숫자를 입력해야 합니다."),
	BONUS_DUPLICATE_ERROR("[ERROR] 로또번호와의 중복은 허용되지 않습니다."),
	SELF_DUPLICATE_ERROR("[ERROR] 로또번호 간의 중복은 허용되지 않습니다.");

	private String message;

	ErrorOperation(String message) {
		this.message = message;
	}

	public void apply() {
		System.out.println(this.message);
		throw new IllegalArgumentException();
	}
}
