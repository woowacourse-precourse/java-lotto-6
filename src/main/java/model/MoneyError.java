package model;

public enum MoneyError {

	EMPTY("[ERROR] 구입금액을 반드시 입력해주세요"),
	NUM_FORM("[ERROR] 구입금액은 반드시 정수인 숫자여야합니다"),
	CHANGES("[ERROR] 거스름돈은 받을 수 없습니다");
	
	private final String error_msg;

	MoneyError(String msg) {
		this.error_msg=msg;
	}
	
	public String getErrorMsg() {
		return error_msg;
	}
}
