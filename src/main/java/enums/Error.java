package enums;

public enum Error {
	WRONG_VALUE("[ERROR] 잘못된 값을 입력하셨습니다."),
	WRONG_AMOUNT("[ERROR] 잘못된 금액을 입력하셨습니다. 로또는 1,000원 단위로 구매가 가능합니다.");
	
	final private String message;

	Error(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
