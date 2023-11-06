package enums;

public enum Error {
	WRONG_VALUE("[ERROR] 잘못된 값을 입력하셨습니다."),
	WRONG_AMOUNT("[ERROR] 로또는 1,000원 단위만 구매가 가능합니다."),
	WRONG_NUMBER("[ERROR] 로또 번호는 1 ~ 45의 숫자로 정해주세요."),
	NUMBER_OVERLAP("[ERROR] 로또 번호가 중복되었습니다."),
	NULL_VALUE("[ERROR] 값을 입력해주세요."),
	ERROR_PART("여기가 오류");
	
	final private String message;

	Error(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
