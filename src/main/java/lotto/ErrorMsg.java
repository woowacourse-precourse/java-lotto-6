package lotto;

public enum ErrorMsg {
	ValidNumberException("로또 번호는 1보다 45 사이의 숫자여야 합니다.");

	public String errorMsg;

	ErrorMsg(String errorMsg) {
		System.out.println("[ERROR] " + this);
		this.errorMsg = errorMsg;
	}
}