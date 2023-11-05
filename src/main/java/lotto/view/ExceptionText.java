package lotto.view;

public enum ExceptionText {
	NUMBER("유효한 숫자 형식이 아닙니다."),
	MULTIPLE("가격은 1000으로 나누어 떨어져야 합니다."),
	EMPTY("구입 가격을 입력해주세요.");
	private final String text;

	ExceptionText(String str) {
		this.text = str;
	}

	public String getText() {
		return text;
	}
}
