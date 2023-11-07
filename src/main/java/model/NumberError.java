package model;

public enum NumberError {

	MORE_OR_LESS("[ERROR] 6개의 번호만 유효합니다"),
	DUPLICATE("[ERROR] 중복된 번호는 유효하지 않습니다"),
	NAN("[ERROR] 번호는 정수인 숫자만 유효합니다(공백 불가)"),
	BOUNDARY("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

	private final String error_msg;
	
	NumberError(String msg) {
		this.error_msg=msg;
	}
	
	public String getErrorMsg() {
		return error_msg;
	}
}
